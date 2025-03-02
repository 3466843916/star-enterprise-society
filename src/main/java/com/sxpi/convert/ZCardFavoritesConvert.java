package com.sxpi.convert;

import com.sxpi.model.dto.ZCardFavoritesDTO;
import com.sxpi.model.entity.ZCardFavorites;
import com.sxpi.model.vo.ZCardFavoritesVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ZCardFavoritesConvert {
    ZCardFavoritesConvert INSTANCE = Mappers.getMapper(ZCardFavoritesConvert.class);
    
    List<ZCardFavoritesVO> convertEntityToVo(List<ZCardFavorites> favoritesList);
    ZCardFavoritesVO convertEntityToVo(ZCardFavorites favorites);
    
    ZCardFavorites convertDtoToEntity(ZCardFavoritesDTO favoritesDTO);
    ZCardFavoritesVO convertDtoToVo(ZCardFavoritesDTO favoritesDTO);
} 