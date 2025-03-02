package com.sxpi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sxpi.model.dto.ZRoleMenuDTO;
import com.sxpi.model.entity.ZRoleMenu;

/**
 * @author happy
 * @create 2024-04-17-{TIME}
 */
public interface ZRoleMenuService extends IService<ZRoleMenu> {
    boolean addPermissionToRole(ZRoleMenuDTO roleMenuDTO);
}
