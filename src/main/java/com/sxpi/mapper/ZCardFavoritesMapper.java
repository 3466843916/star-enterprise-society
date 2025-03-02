package com.sxpi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sxpi.model.entity.ZCardFavorites;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ZCardFavoritesMapper extends BaseMapper<ZCardFavorites> {
    @Select("SELECT * FROM z_card_favorites WHERE user_id = #{userId} AND is_deleted = 0")
    List<ZCardFavorites> selectByUserId(@Param("userId") Long userId);
    
    @Select("SELECT * FROM z_card_favorites WHERE card_id = #{cardId} AND is_deleted = 0")
    List<ZCardFavorites> selectByCardId(@Param("cardId") Long cardId);
} 