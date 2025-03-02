package com.sxpi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sxpi.mapper.ZMenuMapper;
import com.sxpi.mapper.ZUserMapper;
import com.sxpi.model.entity.ZUser;
import com.sxpi.model.vo.ZRoleVO;
import com.sxpi.service.ZRoleService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @author happy
 * @create 2024-01-07-{TIME}
 */
@Service
@Slf4j
@Transactional
public class MyUserDetailsService implements UserDetailsService {
    @Resource
    private ZUserMapper userMapper;

    @Resource
    private ZMenuMapper menuMapper;

    @Resource
    private ZRoleService zRoleService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户
        ZUser user = userMapper.selectOne(new LambdaQueryWrapper<ZUser>().eq(ZUser::getUsername, username));

        if (Objects.isNull(user)) {
            // 用户未找到，抛出异常
            throw new RuntimeException("用户不存在");
        }

        // 获取权限
        List<String> permissions = menuMapper.selectPermsByUserid(user.getId());

        // 给用户添加角色
        ZRoleVO zRoleVO = zRoleService.selectRole(user.getId());

        permissions.add("ROLE_" + zRoleVO.getName());

        user.setPermissions(permissions);

        return user;
    }
}
