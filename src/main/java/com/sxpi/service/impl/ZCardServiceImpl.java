package com.sxpi.service.impl;

import com.sxpi.mapper.ZCardMapper;
import com.sxpi.model.dto.ZCardDTO;
import com.sxpi.model.entity.ZCard;
import com.sxpi.model.vo.ZCardVO;
import com.sxpi.service.ZCardService;
import com.sxpi.convert.ZCardConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class ZCardServiceImpl implements ZCardService {
    private final ZCardMapper cardMapper;
    
    @Override
    public ZCardVO getById(Long id) {
        return ZCardConvert.INSTANCE.convertEntityToVo(cardMapper.selectById(id));
    }
    
    @Override
    public List<ZCardVO> getByUserId(Long userId) {
        return ZCardConvert.INSTANCE.convertEntityToVo(cardMapper.selectByUserId(userId));
    }
    
    @Override
    public List<ZCardVO> getByCompany(String company) {
        return ZCardConvert.INSTANCE.convertEntityToVo(cardMapper.selectByCompany(company));
    }
    
    @Override
    public List<ZCardVO> getByTag(String tag) {
        return ZCardConvert.INSTANCE.convertEntityToVo(cardMapper.selectByTag(tag));
    }
    
    @Override
    public boolean save(ZCardDTO cardDTO) {
        return cardMapper.insert(ZCardConvert.INSTANCE.convertDtoToEntity(cardDTO)) > 0;
    }
    
    @Override
    public boolean update(ZCardDTO cardDTO) {
        return cardMapper.updateById(ZCardConvert.INSTANCE.convertDtoToEntity(cardDTO)) > 0;
    }
    
    @Override
    public boolean removeById(Long id) {
        return cardMapper.deleteById(id) > 0;
    }
    
    @Override
    public Page<ZCardVO> page(Page<ZCard> page, ZCardDTO cardDTO) {
        LambdaQueryWrapper<ZCard> wrapper = new LambdaQueryWrapper<>();
//        wrapper.like(StringUtils.isNotBlank(cardDTO.getName()), ZCard::getName, cardDTO.getName())
//              .like(StringUtils.isNotBlank(cardDTO.getCompany()), ZCard::getCompany, cardDTO.getCompany())
//              .like(StringUtils.isNotBlank(cardDTO.getTag()), ZCard::getTag, cardDTO.getTag())
//              .eq(cardDTO.getStatus() != null, ZCard::getStatus, cardDTO.getStatus())
//              .orderByDesc(ZCard::getCreateTime);
              
        Page<ZCard> cardPage = cardMapper.selectPage(page, wrapper);
        Page<ZCardVO> voPage = new Page<>(page.getCurrent(), page.getSize(), page.getTotal());
        voPage.setRecords(ZCardConvert.INSTANCE.convertEntityToVo(cardPage.getRecords()));
        return voPage;
    }
} 