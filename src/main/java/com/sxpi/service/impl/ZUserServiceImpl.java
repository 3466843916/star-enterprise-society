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
import com.sxpi.model.dto.Login;
import com.sxpi.model.dto.ZUserDTO;
import com.sxpi.model.entity.ZUser;
import com.sxpi.model.entity.ZUserRole;
import com.sxpi.model.enums.IsDeletedEnum;
import com.sxpi.model.enums.RoleEnum;
import com.sxpi.model.page.PageInfo;
import com.sxpi.model.page.PageResult;
import com.sxpi.model.vo.ZUserVO;
import com.sxpi.model.vo.ZMenuVO;
import com.sxpi.model.vo.ZRoleVO;
import com.sxpi.security.MobileAuthenticationToken;
import com.sxpi.service.*;
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

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;

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

    @Resource
    private ZLoginService zLoginService;

    @Override
    public ZUserVO loginOrRegister(Login login) {

        String phone = zLoginService.getPhone(login);       // 真实手机号
//        String phone = login.getPhone();                  // 模拟手机号

        // 1. 检查用户是否存在
        ZUser user = userMapper.selectOne(new LambdaQueryWrapper<ZUser>().eq(ZUser::getPhone, phone));

        if (user == null) {
            // === 注册逻辑 ===
            user = new ZUser();
            user.setUsername(initUsername()); // 生成唯一用户名
            user.setPhone(phone);

            userMapper.insert(user); // 插入后 user.getId() 自动填充

            // 赋予默认角色
            ZUserRole userRole = new ZUserRole();
            userRole.setUserId(user.getId());
            userRole.setRoleId(Long.valueOf(RoleEnum.USER.getCode())); // 避免硬编码
            zUserRoleService.addRole(userRole);
        } else {
            // === 登录逻辑 ===
            Authentication authentication = authenticationManager.authenticate(new MobileAuthenticationToken(phone));
            user = (ZUser) authentication.getPrincipal();
        }

        // 2. 生成 JWT 令牌
        String token = JwtUtil.createJWT(user.getId().toString());

        // 3. 构造 VO 返回
        ZUserVO userVO = ZUserConvert.INSTANCE.convertEntityToVo(user);
        userVO.setToken(token);

        // 4. 绑定用户角色与权限
        userVO.setRole(zRoleService.selectRole(userVO.getId()));
        userVO.setPerms(zMenuService.getInfoByUserId(userVO.getId()));

        // 5. 存入 Redis 缓存
        redisCache.setCacheObject(userVO.getId().toString(), userVO);

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
//     * @param id 用户主键
     * @return 结果
     */
//    @Override
//    public int deleteUserById(Long id)
//    {
//        return userMapper.deleteUserById(id);
//    }


    private String initUsername() {
        String username;
        Random random = new Random();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmssSSS"); // 小时+分+秒+毫秒（9位）

        do {
            // 获取当前时间并格式化
            String timestamp = LocalDateTime.now().format(formatter); // 9 位时间信息
            int randomNum = random.nextInt(10); // 生成 1 位随机数，确保总共 10 位
            username = timestamp + randomNum;
        } while (isUsernameExists(username)); // 如果用户名已存在，则重新生成

        return username;
    }

    private boolean isUsernameExists(String username) {
        ZUser existingUser = userMapper.selectOne(new LambdaQueryWrapper<ZUser>()
                .eq(ZUser::getUsername, username));
        return existingUser != null;
    }


}
