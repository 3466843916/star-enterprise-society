package com.sxpi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sxpi.model.entity.ZRole;
import com.sxpi.model.vo.ZRoleVO;

import java.util.List;

/**
 * @author happy
 * @create 2024-04-17-{TIME}
 */
public interface ZRoleService extends IService<ZRole> {
    boolean del(Integer roleId);

    boolean del(List<Integer> roleIds);

    ZRoleVO selectRole(Long id);
}
