package com.sxpi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sxpi.model.entity.ZResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ZResourceMapper extends BaseMapper<ZResource> {
    @Select("SELECT * FROM z_resource WHERE user_id = #{userId} AND is_deleted = 0")
    List<ZResource> selectByUserId(@Param("userId") Long userId);
    
    @Select("SELECT * FROM z_resource WHERE category = #{category} AND is_deleted = 0")
    List<ZResource> selectByCategory(@Param("category") String category);
} 