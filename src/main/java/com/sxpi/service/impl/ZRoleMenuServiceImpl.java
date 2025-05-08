package com.sxpi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxpi.mapper.ZRoleMapper;
import com.sxpi.mapper.ZRoleMenuMapper;
import com.sxpi.model.dto.ZRoleMenuDTO;
import com.sxpi.model.entity.ZRole;
import com.sxpi.model.entity.ZRoleMenu;
import com.sxpi.service.ZRoleMenuService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author happy
 * @create 2024-04-17-{TIME}
 */
@Service
@Transactional

public class ZRoleMenuServiceImpl extends ServiceImpl<ZRoleMenuMapper, ZRoleMenu> implements ZRoleMenuService {

    @Resource
    private ZRoleMenuMapper roleMenuMapper;

    @Resource
    private ZRoleMapper roleMapper;

    @Override
    public boolean addPermissionToRole(ZRoleMenuDTO roleMenuDTO) {
        // 判断角色是否存在
        ZRole role = roleMapper.selectById(roleMenuDTO.getRoleId());
        if (role == null) {
            // 角色不存在，返回失败
            return false;
        }

        int sum = 0;
        // 构建角色-菜单关系记录
        for (Long menuId : roleMenuDTO.getMenuIds()) {
            ZRoleMenu roleMenu = new ZRoleMenu();
            roleMenu.setRoleId(roleMenuDTO.getRoleId());
            roleMenu.setMenuId(menuId);
            sum += roleMenuMapper.insert(roleMenu);
        }
        int size = roleMenuDTO.getMenuIds().size();

        return sum == size;  // 判断插入数量是否等于菜单数量
    }
}
