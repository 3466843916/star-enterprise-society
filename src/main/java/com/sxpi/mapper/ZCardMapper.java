package com.sxpi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sxpi.model.entity.ZCard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ZCardMapper extends BaseMapper<ZCard> {
    @Select("SELECT * FROM z_card WHERE user_id = #{userId} AND is_deleted = 0")
    List<ZCard> selectByUserId(@Param("userId") Long userId);
    
    @Select("SELECT * FROM z_card WHERE company = #{company} AND is_deleted = 0")
    List<ZCard> selectByCompany(@Param("company") String company);
    
    @Select("SELECT * FROM z_card WHERE tags LIKE CONCAT('%',#{tag},'%') AND is_deleted = 0")
    List<ZCard> selectByTag(@Param("tag") String tag);
} 