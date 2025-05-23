package com.sxpi.controller;

import com.sxpi.common.result.Result;
import com.sxpi.common.result.ResultCodeEnum;
import com.sxpi.costant.FileDirConstant;
import com.sxpi.model.dto.Login;
import com.sxpi.model.dto.ZUserDTO;
import com.sxpi.model.entity.ZUser;
import com.sxpi.model.page.PageResult;
import com.sxpi.model.vo.ZUserRoleVO;
import com.sxpi.model.vo.ZUserVO;
import com.sxpi.service.ZImageService;
import com.sxpi.service.ZUserService;

import com.sxpi.utils.SecurityUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * @author happy
 * @create 2024-10-29-{TIME}
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class ZUserController {

    @Resource
    private ZUserService userService;

    @Resource
    private ZImageService imageService;

    @GetMapping("/hello")
//    @PreAuthorize("hasAuthority('hello')")
    public String hello() {
        return "hello";
    }

    /**
     * 查询用户列表
     */
//    @PreAuthorize("@ss.hasPermi('system:user:list')")
    @GetMapping("/list")
    public Result<PageResult<ZUserVO>> list(ZUser user)
    {
        PageResult<ZUserVO> list = userService.selectUserList(user);
        return Result.ok(list);
    }

    /**
     * 获取用户详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:user:query')")
    @GetMapping(value = "/{id}")
    public Result<ZUserVO> getInfo(@PathVariable("id") Long id)
    {
        return Result.ok(userService.selectUserById(id));
    }
    /**
     * 修改用户
     */
//    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @PutMapping
    public Result edit(@RequestBody ZUser user)
    {
        return Result.ok(userService.updateUser(user));
    }
//
//    /**
//     * 删除用户
//     */
////    @PreAuthorize("@ss.hasPermi('system:user:remove')")
//    @DeleteMapping("/{ids}")
//    public Result remove(@PathVariable( name = "ids" ) Long[] ids)
//    {
//        return Result.ok(userService.deleteUserByIds(ids));
//    }

    @PostMapping("/login")
    public Result<ZUserVO> loginOrRegister(@RequestBody Login login) {
        ZUserVO userVO = userService.loginOrRegister(login);
        return Result.ok(userVO);
    }
    @PostMapping("/loginUser")
    public Result<ZUserVO> login(@RequestBody ZUserDTO userDTO) {
        ZUserVO userVO = userService.login(userDTO);
        return Result.ok(userVO);
    }

    @PostMapping("/register")
    public Result<ZUserVO> register(@RequestBody ZUserDTO userDTO) {
        ZUserVO userVO = userService.register(userDTO);
        return Result.ok(userVO);
    }

    @PostMapping("/logout")
    public Result<String> logout(HttpServletRequest request) {
        ResultCodeEnum logout = userService.logout(request);
        return Result.build(null, logout);
    }

    /**
     * 头像上传
     */
    @PostMapping("/avatar")
    public Result<String> avatar(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            ZUser loginUser = SecurityUtils.getLoginUser();
            log.info(loginUser.getUsername());
            String uuid = UUID.randomUUID() + loginUser.getUsername() + loginUser.getId();
            String avatar = imageService.uploadImageFile(FileDirConstant.HEAD, file, uuid);

            loginUser.setAvatar(avatar);


            userService.updateById(loginUser);
            return Result.ok("图片上传成功");
        }
        return Result.fail("上传图片异常，请联系管理员");
    }

    /**
     * 重置密码
     */
    @PutMapping("/updatePwd")
    public Result<String> updatePwd(String oldPassword, String newPassword) {
        ZUser loginUser = SecurityUtils.getLoginUser();

        // 这里从数据库查一次最新的密码
        ZUser dbUser = userService.getById(loginUser.getId());
        String password = dbUser.getPassword();

        if (!SecurityUtils.matchesPassword(oldPassword, password)) {
            return Result.fail("修改密码失败，旧密码错误");
        }

        if (SecurityUtils.matchesPassword(newPassword, password)) {
            return Result.fail("新密码不能与旧密码相同");
        }

        String encryptedNewPassword = SecurityUtils.encryptPassword(newPassword);
        dbUser.setPassword(encryptedNewPassword);

        boolean isSuccess = userService.updateById(dbUser);
        return isSuccess ? Result.ok() : Result.fail("修改密码异常，请联系管理员");
    }


    /**
     * 注销用户
     * @param id 用户ID
     */
    @GetMapping("/del/{id}")
    public Result<String> cancel(@PathVariable Integer id) {
        Boolean b = userService.cancel(id);
        if (b) {
            // 注销成功
            return Result.ok("注销成功");
        }
        // 注销失败
        return Result.fail("注销失败");
    }

    @GetMapping("/time/{userId}")
    public Result<ZUserRoleVO> getStartAndDeadline(@PathVariable Integer userId) {
        ZUserRoleVO zUserRoleVO = userService.getStartAndDeadline(userId);
        return Result.ok(zUserRoleVO);
    }
}
