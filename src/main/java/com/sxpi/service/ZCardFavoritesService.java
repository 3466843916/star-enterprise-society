package com.sxpi.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxpi.model.dto.ZCardFavoritesDTO;
import com.sxpi.model.entity.ZCardFavorites;
import com.sxpi.model.vo.ZCardFavoritesVO;

import java.util.List;

public interface ZCardFavoritesService {
    ZCardFavoritesVO getById(Long id);
    
    List<ZCardFavoritesVO> getByUserId(Long userId);
    
    List<ZCardFavoritesVO> getByCardId(Long cardId);
    
    boolean save(ZCardFavoritesDTO favoritesDTO);
    
    boolean removeById(Long id);
    
    Page<ZCardFavoritesVO> page(Page<ZCardFavorites> page, ZCardFavoritesDTO favoritesDTO);
} 