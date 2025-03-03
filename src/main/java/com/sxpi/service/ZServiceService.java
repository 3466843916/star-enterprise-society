package com.sxpi.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxpi.model.dto.ZServiceDTO;
import com.sxpi.model.entity.ZService;
import com.sxpi.model.page.PageResult;
import com.sxpi.model.vo.ZServiceVO;

import java.util.List;

public interface ZServiceService {
    ZServiceVO getById(Long id);
    
    List<ZServiceVO> getByName(String name);
    
    boolean save(ZServiceDTO serviceDTO);
    
    boolean update(ZServiceDTO serviceDTO);
    
    boolean removeById(Long id);
    
    Page<ZServiceVO> page(Page<ZService> page, ZServiceDTO serviceDTO);

    PageResult<ZServiceVO> list(ZServiceDTO zServiceDTO);
}