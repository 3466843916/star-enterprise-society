package com.sxpi.config;

import com.sxpi.security.MobileAuthenticationProvider;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author happy
 * @create 2024-01-07-{TIME}
 */
@Configuration
@EnableMethodSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MobileAuthenticationSecurityConfig implements WebMvcConfigurer {

    @Resource
    private UserDetailsService userDetailsService;

    @Bean
    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        //此处可添加别的规则,目前只设置 允许双 //
        firewall.setAllowUrlEncodedDoubleSlash(true);
        return firewall;
    }

    @Bean
    public MobileAuthenticationProvider mobileAuthenticationProvider() {
        MobileAuthenticationProvider provider = new MobileAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * 获取AuthenticationManager（认证管理器），登录时认证使用
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http
//                                                   MyLoginFilter loginFilter,
//                                                   MyAuthenticationHandler authenticationHandler,
//                                                   MyRememberMeServices rememberMeServices
    ) throws Exception {
        http
                // 关闭csrf
                .csrf().disable()
                // 不通过Session获取SecurityContext
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
//                // 对于登录接口，允许匿名访问
//                .requestMatchers("/**").permitAll()
//                .requestMatchers("/user/login").anonymous();
//                .anyRequest().authenticated();
                // 出上面的所有请求，全部都需鉴权认证
                .requestMatchers("/*").permitAll();
        return http.build();
    }
}
