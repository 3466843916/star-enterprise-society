package com.sxpi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sxpi.model.entity.ZMemberDisplay;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ZMemberDisplayMapper extends BaseMapper<ZMemberDisplay> {
    @Select("SELECT * FROM z_member_display WHERE user_id = #{userId} AND is_deleted = 0")
    List<ZMemberDisplay> selectByUserId(@Param("userId") Long userId);
    
    @Select("SELECT * FROM z_member_display WHERE type = #{type} AND is_deleted = 0")
    List<ZMemberDisplay> selectByType(@Param("type") Integer type);
} 