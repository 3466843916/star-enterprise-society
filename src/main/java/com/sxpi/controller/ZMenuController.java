package com.sxpi.controller;

import com.sxpi.common.result.Result;
import com.sxpi.convert.ZMenuConvert;
import com.sxpi.model.dto.ZMenuDTO;
import com.sxpi.model.vo.ZMenuVO;
import com.sxpi.service.ZMenuService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author happy
 * @create 2025-02-15-{TIME}
 */
@RestController
@RequestMapping("/menu")
public class ZMenuController {
    @Resource
    private ZMenuService menuService;

    // todo 给下面两个做分页查询
    /**
     * 根据用户ID获取某用户的权限
     * @param userId 用户ID
     */
    @GetMapping("/byUser/{userId}")
    public Result<List<ZMenuVO>> getInfoByUserId(@PathVariable Integer userId) {
        List<ZMenuVO> menuVOList = menuService.getInfoByUserId(Long.valueOf(userId));
        return Result.ok(menuVOList);
    }

    /**
     * 根据角色ID获取某角色权限
     */
    @GetMapping("/byRole/{roleId}")
    public Result<List<ZMenuVO>> getInfoByRoleId(@PathVariable Integer roleId) {
        List<ZMenuVO> menuVOList = menuService.getInfoByRoleId(Long.valueOf(roleId));
        return Result.ok(menuVOList);
    }

    /**
     * 添加权限信息
     * @param menuDTO 菜单实体类对象
     */
    @PostMapping("/add")
    public Result<String> add(@RequestBody ZMenuDTO menuDTO) {
        boolean save = menuService.save(ZMenuConvert.INSTANCE.convertDtoToEntity(menuDTO));
        if (save) {
            // 添加成功
            return Result.ok("添加成功");
        }
        return Result.fail("添加失败");
    }

    /**
     * 删除菜单
     * @param menuId 要删除的菜单ID
     */
    @DeleteMapping("/{menuId}")
    public Result<String> del(@PathVariable Integer menuId) {
        if (menuService.del(menuId)) {
            // 删除成功
            return Result.ok("删除成功");
        }
        return Result.fail("删除失败");
    }

    /**
     * 批量删除菜单
     * @param menuIds 要删除的菜单的所有ID
     */
    @DeleteMapping("/del")
    public Result<String> delBatch(@RequestBody List<Integer> menuIds) {
        if (menuService.del(menuIds)) {
            // 删除成功
            return Result.ok("删除成功");
        }
        return Result.fail("删除失败");
    }
}
