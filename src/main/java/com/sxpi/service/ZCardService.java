package com.sxpi.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxpi.model.dto.ZCardDTO;
import com.sxpi.model.entity.ZCard;
import com.sxpi.model.vo.ZCardVO;

import java.util.List;

public interface ZCardService {
    ZCardVO getById(Long id);
    
    List<ZCardVO> getByUserId(Long userId);
    
    List<ZCardVO> getByCompany(String company);
    
    List<ZCardVO> getByTag(String tag);
    
    boolean save(ZCardDTO cardDTO);
    
    boolean update(ZCardDTO cardDTO);
    
    boolean removeById(Long id);
    
    Page<ZCardVO> page(Page<ZCard> page, ZCardDTO cardDTO);
} 