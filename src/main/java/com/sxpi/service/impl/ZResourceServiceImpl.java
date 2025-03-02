package com.sxpi.service.impl;

import com.sxpi.mapper.ZResourceMapper;
import com.sxpi.model.dto.ZResourceDTO;
import com.sxpi.model.entity.ZResource;
import com.sxpi.model.page.PageResult;
import com.sxpi.model.vo.ZResourceVO;
import com.sxpi.service.ZResourceService;
import com.sxpi.convert.ZResourceConvert;
import com.sxpi.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;

@Service
@RequiredArgsConstructor
public class ZResourceServiceImpl implements ZResourceService {
    private final ZResourceMapper resourceMapper;
    
    @Override
    public ZResourceVO getById(Long id) {
        return ZResourceConvert.INSTANCE.convertEntityToVo(resourceMapper.selectById(id));
    }
    
    @Override
    public List<ZResourceVO> getByUserId(Long userId) {
        return ZResourceConvert.INSTANCE.convertEntityToVo(resourceMapper.selectByUserId(userId));
    }
    
    @Override
    public List<ZResourceVO> getByCategory(String category) {
        return ZResourceConvert.INSTANCE.convertEntityToVo(resourceMapper.selectByCategory(category));
    }
    
    @Override
    public boolean save(ZResourceDTO resourceDTO) {
        return resourceMapper.insert(ZResourceConvert.INSTANCE.convertDtoToEntity(resourceDTO)) > 0;
    }
    
    @Override
    public boolean update(ZResourceDTO resourceDTO) {
        return resourceMapper.updateById(ZResourceConvert.INSTANCE.convertDtoToEntity(resourceDTO)) > 0;
    }
    
    @Override
    public boolean removeById(Long id) {
        return resourceMapper.deleteById(id) > 0;
    }

    @Override
    public Page<ZResourceVO> page(Page<ZResource> page, ZResourceDTO resourceDTO) {
        return null;
    }

    @Override
    public PageResult<ZResourceVO> selectResourceList(ZResource resource) {
        Page<ZResource> page = new Page<>(resource.getPageNo(), resource.getPageSize());
        
        LambdaQueryWrapper<ZResource> queryWrapper = new LambdaQueryWrapper<>();
        
//        queryWrapper.like(resource.getName() != null, ZResource::getName, resource.getName())
//                   .eq(resource.getType() != null, ZResource::getType, resource.getType())
//                   .eq(resource.getStatus() != null, ZResource::getStatus, resource.getStatus())
//                   .orderByDesc(ZResource::getCreateTime);
        
        IPage<ZResource> resourcePage = resourceMapper.selectPage(page, queryWrapper);
        
        List<ZResourceVO> resourceVOS = ZResourceConvert.INSTANCE.convertEntityToVo(resourcePage.getRecords());
        
        return PageUtil.createPageResult(resource.getPageNo(), resource.getPageSize(), resourceVOS, resourcePage.getTotal());
    }
    
    private ZResourceVO toVO(ZResource entity) {
        if (entity == null) {
            return null;
        }
        ZResourceVO vo = new ZResourceVO();
        BeanUtils.copyProperties(entity, vo);
        return vo;
    }
    
    private List<ZResourceVO> toVOList(List<ZResource> entityList) {
        if (entityList == null) {
            return Collections.emptyList();
        }
        return entityList.stream()
                .map(this::toVO)
                .collect(Collectors.toList());
    }
} 