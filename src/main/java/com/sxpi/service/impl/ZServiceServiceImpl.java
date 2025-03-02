package com.sxpi.service.impl;

import com.sxpi.mapper.ZServiceMapper;
import com.sxpi.model.dto.ZServiceDTO;
import com.sxpi.model.entity.ZService;
import com.sxpi.model.vo.ZServiceVO;
import com.sxpi.service.ZServiceService;
import com.sxpi.convert.ZServiceConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class ZServiceServiceImpl implements ZServiceService {
    private final ZServiceMapper serviceMapper;
    
    @Override
    public ZServiceVO getById(Long id) {
        return ZServiceConvert.INSTANCE.convertEntityToVo(serviceMapper.selectById(id));
    }
    
    @Override
    public List<ZServiceVO> getByName(String name) {
        return ZServiceConvert.INSTANCE.convertEntityToVo(serviceMapper.selectByName(name));
    }
    
    @Override
    public boolean save(ZServiceDTO serviceDTO) {
        return serviceMapper.insert(ZServiceConvert.INSTANCE.convertDtoToEntity(serviceDTO)) > 0;
    }
    
    @Override
    public boolean update(ZServiceDTO serviceDTO) {
        return serviceMapper.updateById(ZServiceConvert.INSTANCE.convertDtoToEntity(serviceDTO)) > 0;
    }
    
    @Override
    public boolean removeById(Long id) {
        return serviceMapper.deleteById(id) > 0;
    }
    
    @Override
    public Page<ZServiceVO> page(Page<ZService> page, ZServiceDTO serviceDTO) {
        LambdaQueryWrapper<ZService> wrapper = new LambdaQueryWrapper<>();
//        wrapper.like(StringUtils.isNotBlank(serviceDTO.getName()), ZService::getName, serviceDTO.getName())
//              .eq(serviceDTO.getType() != null, ZService::getType, serviceDTO.getType())
//              .eq(serviceDTO.getStatus() != null, ZService::getStatus, serviceDTO.getStatus())
//              .orderByDesc(ZService::getCreateTime);
              
        Page<ZService> servicePage = serviceMapper.selectPage(page, wrapper);
        Page<ZServiceVO> voPage = new Page<>(page.getCurrent(), page.getSize(), page.getTotal());
        voPage.setRecords(ZServiceConvert.INSTANCE.convertEntityToVo(servicePage.getRecords()));
        return voPage;
    }
} 