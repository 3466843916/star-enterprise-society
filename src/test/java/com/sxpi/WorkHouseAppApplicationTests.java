package com.sxpi;
import com.sxpi.mapper.ZMenuMapper;
import com.sxpi.mapper.ZRoleMapper;
import com.sxpi.service.ZUserRoleService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class WorkHouseAppApplicationTests {

    @Resource
    private ZRoleMapper roleMapper;

    @Resource
    private ZMenuMapper menuMapper;

    @Resource
    private ZUserRoleService userRoleService;
    @Test
    void contextLoads() {
        List<String> list = roleMapper.selectRole(1L);
        System.out.println(list);
    }

}
