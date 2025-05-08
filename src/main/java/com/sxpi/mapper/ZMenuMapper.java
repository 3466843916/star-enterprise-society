package com.sxpi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sxpi.model.entity.ZMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author happy
 * @create 2024-04-17-{TIME}
 */
@Mapper
public interface ZMenuMapper extends BaseMapper<ZMenu> {
    List<String> selectPermsByUserid(Long id);

    List<ZMenu> selectInfoByUserId(Long userId);

    List<ZMenu> selectInfoByRoleId(Long roleId);
}
