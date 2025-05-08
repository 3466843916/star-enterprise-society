package com.sxpi.config;

import com.sxpi.interceptor.ProjectInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author happy
 * @create 2024-01-03-{TIME}
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Bean
    public ProjectInterceptor getFrontUserInterceptor(){
        return new ProjectInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getFrontUserInterceptor())
                .addPathPatterns("/**")
//                .excludePathPatterns("/user/login", "/user/register","/user/loginUser")
                .excludePathPatterns("/user/hello")
//                .excludePathPatterns("/banner/**")
                .excludePathPatterns("/user/login", "/img/**", "/user/loginUser","/user/register")
                .excludePathPatterns("/banner/**", "/resource/list");
                ;

    }

    /**
     * 解决 No mapping for GET /favicon.ico 访问静态资源图标
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/favicon.ico").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}


