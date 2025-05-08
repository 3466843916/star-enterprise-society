package com.sxpi.utils;

import com.sxpi.common.exception.ServiceException;
import com.sxpi.model.entity.ZUser;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.List;

/**
 * 安全服务工具类
 *
 * @author happy
 */
public class SecurityUtils
{

    /**
     * 用户ID
     **/
    public static Long getUserId()
    {
        try
        {
            return getLoginUser().getId();
        }
        catch (Exception e)
        {
            throw new ServiceException("获取用户ID异常", HttpStatus.UNAUTHORIZED.value());
        }
    }

    /**
     * 获取用户账户
     **/
    public static String getUsername()
    {
        try
        {
            return getLoginUser().getUsername();
        }
        catch (Exception e)
        {
            throw new ServiceException("获取用户账户异常", HttpStatus.UNAUTHORIZED.value());
        }
    }


    /**
     * 获取用户
     **/
    public static ZUser getLoginUser()
    {
        try
        {
            return (ZUser) getAuthentication().getPrincipal();
        }
        catch (Exception e)
        {
            throw new ServiceException("获取用户信息异常", HttpStatus.UNAUTHORIZED.value());
        }
    }

    /**
     * 获取Authentication
     */
    public static Authentication getAuthentication()
    {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 生成BCryptPasswordEncoder密码
     *
     * @param password 密码
     * @return 加密字符串
     */
    public static String encryptPassword(String password)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    /**
     * 判断密码是否相同
     *
     * @param rawPassword 真实密码
     * @param encodedPassword 加密后字符
     * @return 结果
     */
    public static boolean matchesPassword(String rawPassword, String encodedPassword)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    /**
     * 是否为管理员
     *
     * @param userId 用户ID
     * @return 结果
     */
    public static boolean isAdmin(Long userId)
    {
        return userId != null && 1L == userId;
    }


    public static List<String> getPermsByUserId() {
        Authentication authentication = getAuthentication();
        ZUser principal = (ZUser) authentication.getPrincipal();

        List<String> permissions = principal.getPermissions();
        permissions.remove(permissions.size() - 1);

        return permissions;
    }

    public static String getRoleByUserId() {
        // 获取当前认证信息
        Authentication authentication = getAuthentication();

        // 获取当前用户的Principal（即ZUser）
        ZUser principal = (ZUser) authentication.getPrincipal();

        // 获取用户的权限列表
        Collection<? extends GrantedAuthority> authorities = principal.getAuthorities();

        // 遍历 authorities 列表，找到以 "ROLE_" 开头的角色
        for (GrantedAuthority authority : authorities) {
            String authorityName = authority.getAuthority();  // 获取角色名称（如：ROLE_Admin）

            if (authorityName.startsWith("ROLE_")) {
                // 返回去掉 "ROLE_" 前缀的角色名称（如：Admin）
                return authorityName.substring(5);
            }
        }

        return null;  // 如果没有找到角色，返回 null
    }


    /**
     * 验证用户是否具备某权限
     *
     * @param permission 权限字符串
     * @return 用户是否具备某权限
     */
//    public static boolean hasPermi(String permission)
//    {
//        return hasPermi(getLoginUser().getPermissions(), permission);
//    }

    /**
     * 判断是否包含权限
     *
     * @param authorities 权限列表
     * @param permission 权限字符串
     * @return 用户是否具备某权限
     */
//    public static boolean hasPermi(Collection<String> authorities, String permission)
//    {
//        return authorities.stream().filter(StringUtils::hasText)
//                .anyMatch(x -> Constants.ALL_PERMISSION.equals(x) || PatternMatchUtils.simpleMatch(x, permission));
//    }

    /**
     * 验证用户是否拥有某个角色
     *
     * @param role 角色标识
     * @return 用户是否具备某角色
     */
//    public static boolean hasRole(String role)
//    {
//        List<SysRole> roleList = getLoginUser().getUser().getRoles();
//        Collection<String> roles = roleList.stream().map(SysRole::getRoleKey).collect(Collectors.toSet());
//        return hasRole(roles, role);
//    }

    /**
     * 判断是否包含角色
     *
     * @param roles 角色列表
     * @param role 角色
     * @return 用户是否具备某角色权限
     */
//    public static boolean hasRole(Collection<String> roles, String role)
//    {
//        return roles.stream().filter(StringUtils::hasText)
//                .anyMatch(x -> Constants.SUPER_ADMIN.equals(x) || PatternMatchUtils.simpleMatch(x, role));
//    }

}
