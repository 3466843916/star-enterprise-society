package com.sxpi.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxpi.convert.ZRoleConvert;
import com.sxpi.mapper.ZRoleMapper;
import com.sxpi.mapper.ZRoleMenuMapper;
import com.sxpi.mapper.ZUserRoleMapper;
import com.sxpi.model.entity.ZRole;
import com.sxpi.model.entity.ZRoleMenu;
import com.sxpi.model.entity.ZUserRole;
import com.sxpi.model.enums.IsDeletedEnum;
import com.sxpi.model.vo.ZRoleVO;
import com.sxpi.service.ZRoleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author happy
 * @create 2024-04-17-{TIME}
 */
@Service
@Transactional

public class ZRoleServiceImpl extends ServiceImpl<ZRoleMapper, ZRole> implements ZRoleService {
    @Resource
    private ZRoleMapper roleMapper;

    @Resource
    private ZRoleMenuMapper roleMenuMapper;

    @Resource
    private ZUserRoleMapper userRoleMapper;

    @Override
    public boolean del(Integer roleId) {
        // 删除角色表相对应记录
        LambdaUpdateWrapper<ZRole> set1 = new LambdaUpdateWrapper<ZRole>()
                .eq(ZRole::getId, roleId)
                .set(ZRole::getIsDeleted, IsDeletedEnum.DELETE.getCode());
        int update1 = roleMapper.update(new ZRole(), set1);

        // 删除角色-权限相对应记录
        LambdaUpdateWrapper<ZRoleMenu> set2 = new LambdaUpdateWrapper<ZRoleMenu>()
                .eq(ZRoleMenu::getRoleId, roleId)
                .set(ZRoleMenu::getIsDeleted, IsDeletedEnum.DELETE.getCode());
        int update2 = roleMenuMapper.update(new ZRoleMenu(), set2);

        // 删除用户-角色相对应记录
        LambdaUpdateWrapper<ZUserRole> set3 = new LambdaUpdateWrapper<ZUserRole>()
                .eq(ZUserRole::getRoleId, roleId)
                .set(ZUserRole::getIsDeleted, IsDeletedEnum.DELETE.getCode());
        int update3 = userRoleMapper.update(new ZUserRole(), set3);

        return update1 > 0 && update2 > 0 && update3 > 0;
    }

    @Override
    public boolean del(List<Integer> roleIds) {
        // 删除角色表相对应记录
        LambdaUpdateWrapper<ZRole> set1 = new LambdaUpdateWrapper<ZRole>()
                .in(ZRole::getId, roleIds)  // 使用 `in` 来批量匹配多个 `roleId`
                .set(ZRole::getIsDeleted, IsDeletedEnum.DELETE.getCode());
        int update1 = roleMapper.update(new ZRole(), set1);  // update1 直接返回影响的记录数

        // 删除角色-权限相对应记录
        LambdaUpdateWrapper<ZRoleMenu> set2 = new LambdaUpdateWrapper<ZRoleMenu>()
                .in(ZRoleMenu::getRoleId, roleIds)  // 使用 `in` 来批量匹配多个 `roleId`
                .set(ZRoleMenu::getIsDeleted, IsDeletedEnum.DELETE.getCode());
        int update2 = roleMenuMapper.update(new ZRoleMenu(), set2);

        // 删除用户-角色相对应记录
        LambdaUpdateWrapper<ZUserRole> set3 = new LambdaUpdateWrapper<ZUserRole>()
                .in(ZUserRole::getRoleId, roleIds)  // 使用 `in` 来批量匹配多个 `roleId`
                .set(ZUserRole::getIsDeleted, IsDeletedEnum.DELETE.getCode());
        int update3 = userRoleMapper.update(new ZUserRole(), set3);

        // 如果每次更新的记录数都大于 0，说明所有操作成功
        return update1 > 0 && update2 > 0 && update3 > 0;
    }

    @Override
    public ZRoleVO selectRole(Long id) {
        return ZRoleConvert.INSTANCE.convertEntityToVo(roleMapper.selectByUserId(id));
    }
}
