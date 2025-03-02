package com.sxpi.controller;

import com.sxpi.common.result.Result;
import com.sxpi.convert.ZRoleConvert;
import com.sxpi.model.dto.ZRoleDTO;
import com.sxpi.model.entity.ZRole;
import com.sxpi.model.vo.ZRoleVO;
import com.sxpi.service.ZRoleService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author happy
 * @create 2025-02-15-{TIME}
 */
@RestController
@RequestMapping("/role")
public class ZRoleController {
    @Resource
    private ZRoleService roleService;

    /**
     * 添加角色
     * @param roleDTO 角色对象
     */
    @PostMapping
    public Result<String> add(@RequestBody ZRoleDTO roleDTO) {
        if (roleService.save(ZRoleConvert.INSTANCE.convertDtoToEntity(roleDTO))) {
            // 添加成功
            return Result.ok("添加成功");
        }
        return Result.fail("添加失败");
    }

    /**
     * 获取角色列表
     */
    @GetMapping("/list")
    public Result<List<ZRoleVO>> list() {
        List<ZRole> roleList = roleService.list();

        return Result.ok(ZRoleConvert.INSTANCE.convertEntityToVo(roleList));
    }

    /**
     * 删除角色
     * @param roleId 要删除的角色ID
     */
    @DeleteMapping("/{roleId}")
    public Result<String> del(@PathVariable Integer roleId) {
        if (roleService.del(roleId)) {
            // 删除成功
            return Result.ok("删除成功");
        }
        return Result.fail("删除失败");
    }

    /**
     * 批量删除
     * @param ids 要删除的角色的所有ID
     */
    @DeleteMapping("/del")
    public Result<String> delBatch(@RequestBody List<Integer> ids) {
        if (roleService.del(ids)) {
            // 删除成功
            return Result.ok("删除成功");
        }
        return Result.fail("删除失败");
    }


    /**
     * 获取用户角色信息
     * @param userId 用户ID
     */
    @GetMapping("/{userId}")
    public Result<ZRoleVO> getInfo(@PathVariable Integer userId) {
        return Result.ok(roleService.selectRole(Long.valueOf(userId)));
    }
}
