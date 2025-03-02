package com.sxpi.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxpi.model.dto.ZResourceDTO;
import com.sxpi.model.entity.ZResource;
import com.sxpi.model.page.PageResult;
import com.sxpi.model.vo.ZResourceVO;

import java.util.List;

public interface ZResourceService {
    ZResourceVO getById(Long id);
    
    List<ZResourceVO> getByUserId(Long userId);
    
    List<ZResourceVO> getByCategory(String category);
    
    boolean save(ZResourceDTO resourceDTO);
    
    boolean update(ZResourceDTO resourceDTO);
    
    boolean removeById(Long id);
    
    Page<ZResourceVO> page(Page<ZResource> page, ZResourceDTO resourceDTO);
    
    PageResult<ZResourceVO> selectResourceList(ZResource resource);
} 