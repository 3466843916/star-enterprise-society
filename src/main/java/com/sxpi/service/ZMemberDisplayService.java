package com.sxpi.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxpi.model.dto.ZMemberDisplayDTO;
import com.sxpi.model.entity.ZMemberDisplay;
import com.sxpi.model.page.PageResult;
import com.sxpi.model.vo.ZMemberDisplayVO;

import java.util.List;

public interface ZMemberDisplayService {
    ZMemberDisplayVO getById(Long id);
    
    List<ZMemberDisplayVO> getByUserId(Long userId);
    
    List<ZMemberDisplayVO> getByType(Integer type);
    
    boolean save(ZMemberDisplayDTO memberDisplayDTO);
    
    boolean update(ZMemberDisplayDTO memberDisplayDTO);
    
    boolean removeById(Long id);
    
    Page<ZMemberDisplayVO> page(Page<ZMemberDisplay> page, ZMemberDisplayDTO memberDisplayDTO);
    
    PageResult<ZMemberDisplayVO> selectMemberDisplayList(ZMemberDisplay memberDisplay);
} 