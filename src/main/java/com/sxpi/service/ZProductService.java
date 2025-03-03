package com.sxpi.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxpi.model.dto.ZProductDTO;
import com.sxpi.model.entity.ZProduct;
import com.sxpi.model.page.PageResult;
import com.sxpi.model.vo.ZProductVO;

import java.util.List;

public interface ZProductService {
    ZProductVO getById(Long id);
    
    List<ZProductVO> getByStatus(Integer status);
    
    List<ZProductVO> getByName(String name);
    
    boolean save(ZProductDTO productDTO);
    
    boolean update(ZProductDTO productDTO);
    
    boolean removeById(Long id);
    
    Page<ZProductVO> page(Page<ZProduct> page, ZProductDTO productDTO);

    PageResult<ZProductVO> list(ZProductDTO zProductDTO);
} 