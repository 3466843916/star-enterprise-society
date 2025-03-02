package com.sxpi.service.impl;

import com.sxpi.mapper.ZCardFavoritesMapper;
import com.sxpi.model.dto.ZCardFavoritesDTO;
import com.sxpi.model.entity.ZCardFavorites;
import com.sxpi.model.vo.ZCardFavoritesVO;
import com.sxpi.service.ZCardFavoritesService;
import com.sxpi.convert.ZCardFavoritesConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

@Service
@RequiredArgsConstructor
public class ZCardFavoritesServiceImpl implements ZCardFavoritesService {
    private final ZCardFavoritesMapper favoritesMapper;
    
    @Override
    public ZCardFavoritesVO getById(Long id) {
        return ZCardFavoritesConvert.INSTANCE.convertEntityToVo(favoritesMapper.selectById(id));
    }
    
    @Override
    public List<ZCardFavoritesVO> getByUserId(Long userId) {
        return ZCardFavoritesConvert.INSTANCE.convertEntityToVo(favoritesMapper.selectByUserId(userId));
    }
    
    @Override
    public List<ZCardFavoritesVO> getByCardId(Long cardId) {
        return ZCardFavoritesConvert.INSTANCE.convertEntityToVo(favoritesMapper.selectByCardId(cardId));
    }
    
    @Override
    public boolean save(ZCardFavoritesDTO favoritesDTO) {
        return favoritesMapper.insert(ZCardFavoritesConvert.INSTANCE.convertDtoToEntity(favoritesDTO)) > 0;
    }
    
    @Override
    public boolean removeById(Long id) {
        return favoritesMapper.deleteById(id) > 0;
    }
    
    @Override
    public Page<ZCardFavoritesVO> page(Page<ZCardFavorites> page, ZCardFavoritesDTO favoritesDTO) {
        LambdaQueryWrapper<ZCardFavorites> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(favoritesDTO.getUserId() != null, ZCardFavorites::getUserId, favoritesDTO.getUserId())
//              .eq(favoritesDTO.getCardId() != null, ZCardFavorites::getCardId, favoritesDTO.getCardId())
//              .orderByDesc(ZCardFavorites::getCreateTime);
              
        Page<ZCardFavorites> favoritesPage = favoritesMapper.selectPage(page, wrapper);
        Page<ZCardFavoritesVO> voPage = new Page<>(page.getCurrent(), page.getSize(), page.getTotal());
        voPage.setRecords(ZCardFavoritesConvert.INSTANCE.convertEntityToVo(favoritesPage.getRecords()));
        return voPage;
    }
} 