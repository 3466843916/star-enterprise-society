package com.sxpi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxpi.convert.ZUserConvert;
import com.sxpi.convert.ZUserRoleConvert;
import com.sxpi.mapper.ZUserMapper;
import com.sxpi.mapper.ZUserRoleMapper;
import com.sxpi.model.dto.ZUserRoleDTO;
import com.sxpi.model.entity.ZUser;
import com.sxpi.model.entity.ZUserRole;
import com.sxpi.model.page.PageResult;
import com.sxpi.model.vo.ZUserRoleVO;
import com.sxpi.service.ZUserRoleService;
import com.sxpi.utils.PageUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @author happy
 * @create 2024-04-17-{TIME}
 */
@Service
@Transactional

public class ZUserRoleServiceImpl extends ServiceImpl<ZUserRoleMapper, ZUserRole> implements ZUserRoleService {
    @Resource
    private ZUserRoleMapper userRoleMapper;

    @Resource
    private ZUserMapper zUserMapper;

    @Override
    public ZUserRole addRole(ZUserRole userRole) {
        LambdaQueryWrapper<ZUserRole> eq = new LambdaQueryWrapper<ZUserRole>()
                .eq(ZUserRole::getUserId, userRole.getUserId())
                .eq(ZUserRole::getRoleId, userRole.getRoleId());
        ZUserRole userRole1 = userRoleMapper.selectOne(eq);

        if (Objects.isNull(userRole1)) {
            userRoleMapper.insert(userRole);
        }
        return userRole1;
    }

    @Override
    public PageResult<ZUserRoleVO> selectList(ZUserRoleDTO zUserRoleDTO) {
        Page<ZUserRole> page = new Page<>(zUserRoleDTO.getPageNo(), zUserRoleDTO.getPageSize());

        LambdaQueryWrapper<ZUserRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(zUserRoleDTO.getRoleId() != null, ZUserRole::getRoleId, zUserRoleDTO.getRoleId())
                .eq(zUserRoleDTO.getUserId() != null, ZUserRole::getUserId, zUserRoleDTO.getUserId())
                .orderByDesc(ZUserRole::getCreatedTime);

        IPage<ZUserRole> zUserRoleIPage = userRoleMapper.selectPage(page, queryWrapper);

        List<ZUserRoleVO> zUserRoleVOS = ZUserRoleConvert.INSTANCE.convertEntityToVo(zUserRoleIPage.getRecords());

        // 加入用户详情
        zUserRoleVOS.forEach(zUserRoleVO -> {
            Long userId = zUserRoleVO.getUserId();

            ZUser zUser = zUserMapper.selectById(userId);

            zUserRoleVO.setZUserVO(ZUserConvert.INSTANCE.convertEntityToVo(zUser));
        });

        return PageUtil.createPageResult(zUserRoleDTO.getPageNo(), zUserRoleDTO.getPageSize(), zUserRoleVOS, zUserRoleIPage.getTotal());
    }

}
