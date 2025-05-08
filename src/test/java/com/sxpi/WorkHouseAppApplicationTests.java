package com.sxpi;
import com.sxpi.mapper.ZMenuMapper;
import com.sxpi.mapper.ZProductMapper;
import com.sxpi.mapper.ZRoleMapper;
import com.sxpi.service.ZCardFavoritesService;
import com.sxpi.service.ZProductService;
import com.sxpi.service.ZUserRoleService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WorkHouseAppApplicationTests {

    @Resource
    private ZRoleMapper roleMapper;

    @Resource
    private ZMenuMapper menuMapper;

    @Resource
    private ZUserRoleService userRoleService;

    @Resource
    private ZCardFavoritesService zCardFavoritesService;

    @Resource
    private ZProductService productService;

    @Resource
    private ZProductMapper zProductMapper;
    @Test
    void contextLoads() {
//        List<String> list = roleMapper.selectRole(1L);
//        System.out.println(list);
//        List<ZCardFavorites> list = zCardFavoritesService.list();
//        System.out.println(list);
//        ZCardFavoritesVO byId = zCardFavoritesService.getById(3L);

        System.out.println(zProductMapper.selectById(4L));
    }

}
