package com.sxpi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sxpi.model.entity.ZMenu;
import com.sxpi.model.vo.ZMenuVO;

import java.util.List;

/**
 * @author happy
 * @create 2024-04-17-{TIME}
 */
public interface ZMenuService extends IService<ZMenu> {
    List<ZMenuVO> getInfoByUserId(Long userId);

    List<ZMenuVO> getInfoByRoleId(Long roleId);

    boolean del(Integer menuId);

    boolean del(List<Integer> menuIds);
}
