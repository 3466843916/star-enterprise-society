package com.sxpi.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sxpi.mapper.ZMemberDisplayMapper;
import com.sxpi.model.dto.ZMemberDisplayDTO;
import com.sxpi.model.entity.ZMemberDisplay;
import com.sxpi.model.page.PageResult;
import com.sxpi.model.vo.ZMemberDisplayVO;
import com.sxpi.service.ZMemberDisplayService;
import com.sxpi.convert.ZMemberDisplayConvert;
import com.sxpi.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class ZMemberDisplayServiceImpl implements ZMemberDisplayService {
    private final ZMemberDisplayMapper memberDisplayMapper;
    
    @Override
    public ZMemberDisplayVO getById(Long id) {
        return ZMemberDisplayConvert.INSTANCE.convertEntityToVo(memberDisplayMapper.selectById(id));
    }
    
    @Override
    public List<ZMemberDisplayVO> getByUserId(Long userId) {
        return ZMemberDisplayConvert.INSTANCE.convertEntityToVo(memberDisplayMapper.selectByUserId(userId));
    }
    
    @Override
    public List<ZMemberDisplayVO> getByType(Integer type) {
        return ZMemberDisplayConvert.INSTANCE.convertEntityToVo(memberDisplayMapper.selectByType(type));
    }
    
    @Override
    public boolean save(ZMemberDisplayDTO memberDisplayDTO) {
        return memberDisplayMapper.insert(ZMemberDisplayConvert.INSTANCE.convertDtoToEntity(memberDisplayDTO)) > 0;
    }
    
    @Override
    public boolean update(ZMemberDisplayDTO memberDisplayDTO) {
        return memberDisplayMapper.updateById(ZMemberDisplayConvert.INSTANCE.convertDtoToEntity(memberDisplayDTO)) > 0;
    }
    
    @Override
    public boolean removeById(Long id) {
        return memberDisplayMapper.deleteById(id) > 0;
    }
    
    @Override
    public Page<ZMemberDisplayVO> page(Page<ZMemberDisplay> page, ZMemberDisplayDTO memberDisplayDTO) {
        LambdaQueryWrapper<ZMemberDisplay> wrapper = new LambdaQueryWrapper<>();
//        wrapper.like(StringUtils.isNotBlank(memberDisplayDTO.getName()), ZMemberDisplay::getName, memberDisplayDTO.getName())
//              .eq(memberDisplayDTO.getType() != null, ZMemberDisplay::getType, memberDisplayDTO.getType())
//              .eq(memberDisplayDTO.getStatus() != null, ZMemberDisplay::getStatus, memberDisplayDTO.getStatus())
//              .orderByDesc(ZMemberDisplay::getCreateTime);
              
        Page<ZMemberDisplay> memberDisplayPage = memberDisplayMapper.selectPage(page, wrapper);
        Page<ZMemberDisplayVO> voPage = new Page<>(page.getCurrent(), page.getSize(), page.getTotal());
        voPage.setRecords(ZMemberDisplayConvert.INSTANCE.convertEntityToVo(memberDisplayPage.getRecords()));
        return voPage;
    }

    @Override
    public PageResult<ZMemberDisplayVO> selectMemberDisplayList(ZMemberDisplay memberDisplay) {
        Page<ZMemberDisplay> page = new Page<>(memberDisplay.getPageNo(), memberDisplay.getPageSize());
        
        LambdaQueryWrapper<ZMemberDisplay> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(memberDisplay.getName() != null, ZMemberDisplay::getName, memberDisplay.getName())
                   .eq(memberDisplay.getType() != null, ZMemberDisplay::getType, memberDisplay.getType())
                   .eq(memberDisplay.getStatus() != null, ZMemberDisplay::getStatus, memberDisplay.getStatus());
//                   .orderByDesc(ZMemberDisplay::getCreateTime);
        
        IPage<ZMemberDisplay> memberDisplayPage = memberDisplayMapper.selectPage(page, queryWrapper);
        
        List<ZMemberDisplayVO> memberDisplayVOS = ZMemberDisplayConvert.INSTANCE.convertEntityToVo(memberDisplayPage.getRecords());
        
        return PageUtil.createPageResult(memberDisplay.getPageNo(), memberDisplay.getPageSize(), memberDisplayVOS, memberDisplayPage.getTotal());
    }
} 