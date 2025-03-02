package com.sxpi.controller;

import com.sxpi.common.result.Result;
import com.sxpi.model.dto.ZRoleMenuDTO;
import com.sxpi.service.ZRoleMenuService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @author happy
 * @create 2025-02-15-{TIME}
 */
@RestController
@RequestMapping("/roleMenu")
public class ZRoleMenuController {
    @Resource
    private ZRoleMenuService roleMenuService;

    /**
     * 给一个角色添加一个或多个权限
     * @param roleMenuDTO 角色-权限信息
     */
    @PostMapping
    public Result<String> addPermissionToRole(@RequestBody ZRoleMenuDTO roleMenuDTO) {
        boolean isSuccess = roleMenuService.addPermissionToRole(roleMenuDTO);
        if (isSuccess) {
            // 添加成功
            return Result.ok("添加成功");
        }
        return Result.fail("添加失败");
    }
}
