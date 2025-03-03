package com.sxpi.controller;

import com.sxpi.common.result.Result;
import com.sxpi.model.dto.ZUserRoleDTO;
import com.sxpi.model.entity.ZUser;
import com.sxpi.model.entity.ZUserRole;
import com.sxpi.model.page.PageResult;
import com.sxpi.model.vo.ZUserRoleVO;
import com.sxpi.service.ZUserRoleService;
import com.sxpi.utils.SecurityUtils;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author happy
 * @create 2025-02-15-{TIME}
 */
@RestController
@RequestMapping("/userRole")
public class ZUserRoleController {
    @Resource
    private ZUserRoleService userRoleService;

    /**
     * 修改用户角色
     */
    @PutMapping
    public Result<String> edit(ZUserRole zUserRole) {
//        ZUser user = SecurityUtils.getLoginUser();

        ZUserRole userRole = new ZUserRole();
        userRole.setUserId(zUserRole.getUserId());
        userRole.setRoleId(Long.valueOf(zUserRole.getRoleId()));

        if (userRoleService.updateById(userRole)) {
            return Result.ok("修改成功");
        } else {
            return Result.fail("修改失败");
        }
    }

    @GetMapping("/list")
    public Result<PageResult<ZUserRoleVO>> getByRoleId(ZUserRoleDTO zUserRoleDTO) {
        PageResult<ZUserRoleVO> list = userRoleService.selectList(zUserRoleDTO);
        return Result.ok(list);
    }
}
