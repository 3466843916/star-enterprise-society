package com.sxpi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sxpi.model.entity.ZService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ZServiceMapper extends BaseMapper<ZService> {
    @Select("SELECT * FROM z_service WHERE name LIKE CONCAT('%',#{name},'%') AND is_deleted = 0")
    List<ZService> selectByName(@Param("name") String name);
} 