package com.sxpi.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxpi.convert.ZMenuConvert;
import com.sxpi.mapper.ZMenuMapper;
import com.sxpi.mapper.ZRoleMenuMapper;
import com.sxpi.model.entity.ZMenu;
import com.sxpi.model.entity.ZRoleMenu;
import com.sxpi.model.enums.IsDeletedEnum;
import com.sxpi.model.vo.ZMenuVO;
import com.sxpi.service.ZMenuService;
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

public class ZMenuServiceImpl extends ServiceImpl<ZMenuMapper, ZMenu> implements ZMenuService {
    @Resource
    private ZMenuMapper menuMapper;

    @Resource
    private ZRoleMenuMapper roleMenuMapper;

    @Override
    public List<ZMenuVO> getInfoByUserId(Long userId) {
        return ZMenuConvert.INSTANCE.convertEntityToVo(menuMapper.selectInfoByUserId(userId));
    }

    @Override
    public List<ZMenuVO> getInfoByRoleId(Long roleId) {
        return ZMenuConvert.INSTANCE.convertEntityToVo(menuMapper.selectInfoByRoleId(roleId));
    }

    @Override
    public boolean del(Integer menuId) {
        // 删除权限表相对应记录
        LambdaUpdateWrapper<ZMenu> set1 = new LambdaUpdateWrapper<ZMenu>()
                .eq(ZMenu::getId, menuId)
                .set(ZMenu::getIsDeleted, IsDeletedEnum.DELETE.getCode());
        int update1 = menuMapper.update(new ZMenu(), set1);

        // 删除角色-权限相对应记录
        LambdaUpdateWrapper<ZRoleMenu> set2 = new LambdaUpdateWrapper<ZRoleMenu>()
                .eq(ZRoleMenu::getMenuId, menuId)
                .set(ZRoleMenu::getIsDeleted, IsDeletedEnum.DELETE.getCode());
        int update2 = roleMenuMapper.update(new ZRoleMenu(), set2);

        return update1 > 0 && update2 > 0;
    }

    @Override
    public boolean del(List<Integer> menuIds) {
        // 删除权限表相对应记录
        LambdaUpdateWrapper<ZMenu> set1 = new LambdaUpdateWrapper<ZMenu>()
                .in(ZMenu::getId, menuIds)
                .set(ZMenu::getIsDeleted, IsDeletedEnum.DELETE.getCode());
        int update1 = menuMapper.update(new ZMenu(), set1);

        // 删除角色-权限相对应记录
        LambdaUpdateWrapper<ZRoleMenu> set2 = new LambdaUpdateWrapper<ZRoleMenu>()
                .in(ZRoleMenu::getMenuId, menuIds)
                .set(ZRoleMenu::getIsDeleted, IsDeletedEnum.DELETE.getCode());
        int update2 = roleMenuMapper.update(new ZRoleMenu(), set2);

        return update1 > 0 && update2 > 0;
    }
}
