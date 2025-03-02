package com.sxpi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sxpi.model.dto.ZUserRoleDTO;
import com.sxpi.model.entity.ZUserRole;
import com.sxpi.model.page.PageResult;
import com.sxpi.model.vo.ZUserRoleVO;

/**
 * @author happy
 * @create 2024-04-17-{TIME}
 */
public interface ZUserRoleService extends IService<ZUserRole> {
    ZUserRole addRole(ZUserRole userRole);

    PageResult<ZUserRoleVO> selectList(ZUserRoleDTO zUserRoleDTO);
}
