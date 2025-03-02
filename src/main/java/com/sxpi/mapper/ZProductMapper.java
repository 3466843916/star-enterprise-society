package com.sxpi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sxpi.model.entity.ZProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ZProductMapper extends BaseMapper<ZProduct> {
    @Select("SELECT * FROM z_product WHERE status = #{status} AND is_deleted = 0")
    List<ZProduct> selectByStatus(@Param("status") Integer status);
    
    @Select("SELECT * FROM z_product WHERE name LIKE CONCAT('%',#{name},'%') AND is_deleted = 0")
    List<ZProduct> selectByName(@Param("name") String name);
} 