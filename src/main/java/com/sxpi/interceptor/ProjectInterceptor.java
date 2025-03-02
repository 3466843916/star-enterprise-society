package com.sxpi.interceptor;

import com.sxpi.model.entity.ZUser;
import com.sxpi.utils.JwtUtil;
import com.sxpi.utils.RedisCache;
import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Objects;

/**
 * @author happy
 * @create 2024-02-03-{TIME}
 */
@Slf4j
public class ProjectInterceptor implements HandlerInterceptor {
    @Resource
    RedisCache redisCache;

    @Resource
    private AuthenticationManager authenticationManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);

        String token = request.getHeader("Authorization");
        if (token == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);        // 未认证
            // 拦截
            return false;
        }
        Claims claims;
        String id;
        try {
            claims = JwtUtil.parseJWT(token);
            id = claims.getSubject();
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);        // 权限不足
            throw new RuntimeException("token非法");
        }
        // 从redis中获取用户信息
//        String redisKey = PrivacyConstant.FRONT + id;
        String redisKey = id;
        ZUser user = redisCache.getCacheObject(redisKey);
        if (Objects.isNull(user)) {
//            throw new RuntimeException("用户未登录");
//            return false;
            System.out.println("用户未登录");
        }
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa{}" + user);
        // 存入SecurityContextHolder中
        // TODO 获取权限信息封装到Authentication中
//        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
//        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
//
//        User user1 = (User) authenticate.getPrincipal();

        UsernamePasswordAuthenticationToken authenticationToken1 = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken1);

        return true;
    }
}
