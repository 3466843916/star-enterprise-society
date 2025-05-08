package com.sxpi.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: codermzy
 * @Date: 2024/02/19/15:47
 * @Description: mybatis plus 配置类
 */
@Configuration
public class MybatisConfiguration {


    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new MybatisPlusAllSqlLog());

        return interceptor;
    }

}
