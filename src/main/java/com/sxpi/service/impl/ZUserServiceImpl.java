package com.sxpi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxpi.common.result.ResultCodeEnum;
import com.sxpi.convert.ZUserConvert;
import com.sxpi.costant.RequestHeaderCostant;
import com.sxpi.mapper.ZUserMapper;
import com.sxpi.model.dto.ZUserDTO;
import com.sxpi.model.entity.ZUser;
import com.sxpi.model.entity.ZUserRole;
import com.sxpi.model.enums.IsDeletedEnum;
import com.sxpi.model.page.PageInfo;
import com.sxpi.model.page.PageResult;
import com.sxpi.model.vo.ZUserVO;
import com.sxpi.model.vo.ZMenuVO;
import com.sxpi.model.vo.ZRoleVO;
import com.sxpi.service.ZUserService;
import com.sxpi.service.ZMenuService;
import com.sxpi.service.ZRoleService;
import com.sxpi.service.ZUserRoleService;
import com.sxpi.utils.JwtUtil;
import com.sxpi.utils.PageUtil;
import com.sxpi.utils.RedisCache;
import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author happy
 * @create 2024-07-31-{TIME}
 */
@Service
@Slf4j
@Transactional
public class ZUserServiceImpl extends ServiceImpl<ZUserMapper, ZUser> implements ZUserService {

    @Resource
    private ZUserMapper userMapper;

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Resource
    private RedisCache redisCache;

    @Resource
    private ZRoleService zRoleService;

    @Resource
    private ZMenuService zMenuService;

    @Resource
    private ZUserRoleService zUserRoleService;

    @Override
    public ZUserVO login(ZUserDTO userDTO) {
        // 先尝试通过用户名和密码认证
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        ZUser user = (ZUser) authenticate.getPrincipal();

        // 创建JWT token
        String token = JwtUtil.createJWT(user.getId().toString());

        ZUserVO userVO = ZUserConvert.INSTANCE.convertEntityToVo(user);
        userVO.setToken(token);

        // 查找该用户的角色和权限信息
        ZRoleVO zRoleVO = zRoleService.selectRole(userVO.getId());
        List<ZMenuVO> infoByUserId = zMenuService.getInfoByUserId(userVO.getId());

        userVO.setRole(zRoleVO);
        userVO.setPerms(infoByUserId);

        redisCache.setCacheObject(userVO.getId().toString(), user);

        return userVO;
    }

    @Override
    public ZUserVO register(ZUserDTO userDTO) {
        // 判断用户名是否已存在
        ZUser existingUser = userMapper.selectOne(new LambdaQueryWrapper<ZUser>()
                .eq(ZUser::getUsername, userDTO.getUsername()));
        if (existingUser != null) {
            // 如果用户已存在，抛出异常或返回错误信息
            throw new RuntimeException("用户名已存在");
        }

        ZUser user = new ZUser();
        user.setUsername(userDTO.getUsername());            // 设置用户名
        String encodePwd = passwordEncoder.encode(userDTO.getPassword());
        user.setPassword(encodePwd);                        // 设置密码

        userMapper.insert(user);

        // 注册时给用户默认设置角色为： USER
        ZUserRole zUserRole = new ZUserRole();
        ZUser user1 = userMapper.selectOne(new LambdaQueryWrapper<ZUser>().eq(ZUser::getUsername, user.getUsername())
                .eq(ZUser::getPassword, user.getPassword()));
        zUserRole.setUserId(user1.getId());
        zUserRole.setRoleId(2L);        // 默认为普通用户
        zUserRoleService.addRole(zUserRole);

        String jwt = JwtUtil.createJWT(user1.getId().toString());

        ZUserVO userVO = ZUserConvert.INSTANCE.convertEntityToVo(user1);
        userVO.setToken(jwt);

        // 查找该用户的角色和权限信息
        ZRoleVO zRoleVO = zRoleService.selectRole(userVO.getId());
        List<ZMenuVO> infoByUserId = zMenuService.getInfoByUserId(userVO.getId());

        userVO.setRole(zRoleVO);
        userVO.setPerms(infoByUserId);

        redisCache.setCacheObject(userVO.getId().toString(), user);
        return userVO;
    }

    @Override
    public ResultCodeEnum logout(HttpServletRequest request) {
        // 让原先token失效
        try {
            this.loseEfficacy(request);
        } catch (Exception e) {
            return ResultCodeEnum.SC_FORBIDDEN;
//            throw new RuntimeException(e);
        }

        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        ZUser user = (ZUser) authentication.getPrincipal();
        if (user == null) {
            return ResultCodeEnum.SC_UNAUTHORIZED;
        }
        String key = String.valueOf(user.getId());
        redisCache.deleteObject(key);

        return ResultCodeEnum.EXIT_SUCCESS;
    }

    // 把token加入黑名单，使其失效
    private String loseEfficacy (HttpServletRequest request) throws Exception{
        String token = request.getHeader(RequestHeaderCostant.AUTHORIZATION);

        Claims claims;
        String id;
//        try {
        claims = JwtUtil.parseJWT(token);
        id = claims.getSubject();
//        } catch (Exception e) {
//            throw new RuntimeException("token非法");
//        }

        String jti = claims.getId();
        JwtUtil.blacklistToken(jti);

        return id;
    }

    /**
     * 查询用户
     *
     * @param id 用户主键
     * @return 用户
     */
    @Override
    public ZUserVO selectUserById(Long id)
    {
        ZUser user = userMapper.selectUserById(id);
        ZUserVO zUserVO = ZUserConvert.INSTANCE.convertEntityToVo(user);

        // 查找该用户的角色和权限信息
        ZRoleVO zRoleVO = zRoleService.selectRole(id);
        List<ZMenuVO> infoByUserId = zMenuService.getInfoByUserId(id);

        zUserVO.setRole(zRoleVO);
        zUserVO.setPerms(infoByUserId);

        return zUserVO;
    }

    /**
     * 查询用户列表
     *
     * @param user 用户
     * @return 用户
     */
    public PageResult<ZUserVO> selectUserList(ZUser user) {
        // 使用 Page 对象传递分页参数
        Page<ZUser> page = new Page<>(user.getPageNo(), user.getPageSize());

        // 使用 LambdaQueryWrapper
        LambdaQueryWrapper<ZUser> queryWrapper = new LambdaQueryWrapper<>();

        // 根据非null字段动态构建查询条件
        queryWrapper.like(user.getUsername() != null, ZUser::getUsername, user.getUsername())
                .eq(user.getPhone() != null, ZUser::getPhone, user.getPhone())
                .eq(user.getGender() != null, ZUser::getGender, user.getGender())
                .eq(user.getAvatar() != null, ZUser::getAvatar, user.getAvatar())
                .eq(user.getCreatedBy() != null, ZUser::getCreatedBy, user.getCreatedBy())
                .ge(user.getCreatedTime() != null, ZUser::getCreatedTime, user.getCreatedTime());

//        queryWrapper.ge(user.getStartTime() != null, ZUser::getCreatedTime, user.getStartTime())  // 大于等于起始时间
//                .le(user.getEndTime() != null, ZUser::getCreatedTime, user.getEndTime());  // 小于等于结束时间


        // 执行分页查询
        IPage<ZUser> userPage = userMapper.selectPage(page, queryWrapper);

        // 转换为 VO
        List<ZUserVO> userVOS = ZUserConvert.INSTANCE.convertEntityToVo(userPage.getRecords());

        return PageUtil.createPageResult(user.getPageNo(), user.getPageSize(), userVOS, userPage.getTotal());
    }



    /**
     * 新增用户
     *
     * @param user 用户
     * @return 结果
     */
//    @Override
//    public int insertUser(User user)
//    {
//        return userMapper.insertUser(user);
//    }

    /**
     * 修改用户
     *
     * @param user 用户
     * @return 结果
     */
    @Override
    public int updateUser(ZUser user)
    {
        return userMapper.updateUser(user);
    }

    @Override
    public Boolean cancel(Integer id) {
        // 删除用户
        LambdaUpdateWrapper<ZUser> set = new LambdaUpdateWrapper<ZUser>().eq(ZUser::getId, id).set(ZUser::getIsDeleted, IsDeletedEnum.DELETE.getCode());
        int update = userMapper.update(new ZUser(), set);

        // 删除用户-角色相对应记录
        LambdaUpdateWrapper<ZUserRole> set1 = new LambdaUpdateWrapper<ZUserRole>()
                .eq(ZUserRole::getUserId, id)
                .set(ZUserRole::getIsDeleted, IsDeletedEnum.DELETE.getCode());
        boolean update1 = zUserRoleService.update(new ZUserRole(), set1);

        return update > 0 && update1;
    }

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的用户主键
     * @return 结果
     */
//    @Override
//    public int deleteUserByIds(Long[] ids)
//    {
//        return userMapper.deleteUserByIds(ids);
//    }

    /**
     * 删除用户信息
     *
     * @param id 用户主键
     * @return 结果
     */
//    @Override
//    public int deleteUserById(Long id)
//    {
//        return userMapper.deleteUserById(id);
//    }


}
