package com.sxpi.config;

import com.sxpi.model.entity.ZUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.*;


/**
 * @Author: happy
 * @Date: 2024/03/11/21:32
 * @Description: mybatis拦截器，反射填充 createdBy、createdTime、isDeleted、updateBy、updateTime属性
 */
@Component
@Slf4j
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class,
                Object.class})}
)
public class MybatisInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        Object parameter = invocation.getArgs()[1];
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        System.out.println(mappedStatement.getSqlSource().toString());

        SecurityContext context = SecurityContextHolder.getContext();
        Long loginId = 0L;
        if (context != null && context.getAuthentication() != null && context.getAuthentication().isAuthenticated()) {
            // 只有在已认证的情况下才获取用户信息
            Object principal = context.getAuthentication().getPrincipal();
            if (principal instanceof ZUser) {
                ZUser user = (ZUser) principal;
                loginId = user.getId();
            } else {
                // 如果 principal 不是 User 类型，可以处理这个情况
                // 例如抛出异常或者记录日志
            }
        } else {
            // 如果没有认证信息，可以设置默认值，抛出异常，或者记录日志
            // throw new RuntimeException("用户未认证");
            loginId = -1L;  // 设置一个标识值，表示未认证
        }


        if (sqlCommandType == SqlCommandType.INSERT || sqlCommandType == SqlCommandType.UPDATE || sqlCommandType == SqlCommandType.SELECT) {
            fillProperties(parameter, sqlCommandType, loginId);
        }

        return invocation.proceed();
    }

    private void fillProperties(Object parameter, SqlCommandType sqlCommandType, Long loginId) {
        if (parameter instanceof Map) {
            fillMap((Map) parameter, sqlCommandType, loginId);
        } else {
            fillEntity(parameter, sqlCommandType, loginId);
        }
    }

    private void fillMap(Map parameter, SqlCommandType sqlCommandType, Long loginId) {
        for (Object entity : parameter.values()) {
            // 针对ArrayList类型的变量（批量插入）
            if (entity instanceof List) {
                List<?> objects = (List<?>) entity;
                for (Object object : objects) {
                    fillEntity(object, sqlCommandType, loginId);
                }
                continue;
            }
            // 普通的map类型
            fillEntity(entity, sqlCommandType, loginId);
        }
    }

    private void fillEntity(Object parameter, SqlCommandType sqlCommandType, Long loginId) {
        if (sqlCommandType == SqlCommandType.UPDATE) {
            dealUpdate(parameter, loginId);
        } else if (sqlCommandType == SqlCommandType.INSERT) {
            dealInsert(parameter, loginId);
        }
    }

    private void dealInsert(Object parameter, Long loginId) {
        Class<?> clazz = parameter.getClass();
        Field[] fields = getAllFields(clazz);

        for (Field field : fields) {
            try {
                field.setAccessible(true);

                if (Objects.nonNull(field.get(parameter))) {
                    continue;
                }
                if ("createdBy".equals(field.getName())) {
                    field.set(parameter, loginId);
                    field.setAccessible(false);
                } else if ("createdTime".equals(field.getName())) {
                    field.set(parameter, LocalDateTime.now());
                    field.setAccessible(false);
                } else if ("isDeleted".equals(field.getName())) {
                    field.set(parameter, 0);
                    field.setAccessible(false);
                } else {
                    field.setAccessible(false);
                }
            } catch (Exception e) {
                log.error("intercept.dealInsert.error: {}", e.getMessage(), e);
            }

        }
    }

    private void dealUpdate(Object parameter, Long loginId) {
        Class<?> clazz = parameter.getClass();
        Field[] fields = getAllFields(clazz);

        for (Field field : fields) {
            try {
                field.setAccessible(true);

                if (Objects.nonNull(field.get(parameter))) {
                    continue;
                }
                if ("updateBy".equals(field.getName())) {
                    field.set(parameter, loginId);
                    field.setAccessible(false);
                } else if ("updateTime".equals(field.getName())) {
                    field.set(parameter, LocalDateTime.now());
                    field.setAccessible(false);
                } else if ("isDeleted".equals(field.getName())) {
                    field.set(parameter, 0);
                    field.setAccessible(false);
                } else {
                    field.setAccessible(false);
                }
            } catch (Exception e) {
                log.error("intercept.dealUpdate.error: {}", e.getMessage(), e);
            }
        }
    }

    private Field[] getAllFields(Class<?> parameter) {
        List<Field> fieldList = new LinkedList<>();
        while (Objects.nonNull(parameter)) {
            Field[] fields = parameter.getDeclaredFields();
            fieldList.addAll(Arrays.asList(fields));
            parameter = parameter.getSuperclass();
        }

        Field[] fields = new Field[fieldList.size()];

        return fieldList.toArray(fields);
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        Interceptor.super.setProperties(properties);
    }
}
