package com.sxpi.security;

/**
 * @author happy
 * @create 2024-01-07-{TIME}
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 短信登陆鉴权 Provider，要求实现 AuthenticationProvider 接口
 */
/**
 * MobileAuthenticationProvider
 *
 * 调用userDetailsService根据用户名查询用户信息
 *
 * @author majie
 *
 */
public class MobileAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        MobileAuthenticationToken authenticationToken = (MobileAuthenticationToken) authentication;

        UserDetails userDetails = userDetailsService.loadUserByUsername((String) authenticationToken.getPrincipal());

//        if (userDetails == null) {
//            throw new UsernameNotFoundException("用户名/密码无效");
//
//        } else if (!userDetails.isEnabled()) {
//
//            throw new DisabledException("用户已被禁用");
//
//        } else if (!userDetails.isAccountNonExpired()) {
//
//            throw new AccountExpiredException("账号已过期");
//
//        } else if (!userDetails.isAccountNonLocked()) {
//
//            throw new LockedException("账号已被锁定");
//
//        } else if (!userDetails.isCredentialsNonExpired()) {
//
//            throw new LockedException("凭证已过期");
//        }

        MobileAuthenticationToken authenticationResult = new MobileAuthenticationToken(userDetails,
                userDetails.getAuthorities());

        authenticationResult.setDetails(authenticationToken.getDetails());

        return authenticationResult;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return MobileAuthenticationToken.class.isAssignableFrom(authentication);
    }

    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}



