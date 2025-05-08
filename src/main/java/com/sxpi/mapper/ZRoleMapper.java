package com.sxpi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sxpi.model.entity.ZRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author happy
 * @create 2024-04-17-{TIME}
 */
@Mapper
public interface ZRoleMapper extends BaseMapper<ZRole> {

    List<String> selectRole(Long id);

    ZRole selectByUserId(Long id);
}
