package com.sxpi.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sxpi.mapper.ZProductMapper;
import com.sxpi.model.dto.ZProductDTO;
import com.sxpi.model.entity.ZProduct;
import com.sxpi.model.page.PageResult;
import com.sxpi.model.vo.ZProductVO;
import com.sxpi.service.ZProductService;
import com.sxpi.convert.ZProductConvert;
import com.sxpi.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class ZProductServiceImpl implements ZProductService {
    private final ZProductMapper productMapper;
    
    @Override
    public ZProductVO getById(Long id) {
        return ZProductConvert.INSTANCE.convertEntityToVo(productMapper.selectById(id));
    }
    
    @Override
    public List<ZProductVO> getByStatus(Integer status) {
        return ZProductConvert.INSTANCE.convertEntityToVo(productMapper.selectByStatus(status));
    }
    
    @Override
    public List<ZProductVO> getByName(String name) {
        return ZProductConvert.INSTANCE.convertEntityToVo(productMapper.selectByName(name));
    }
    
    @Override
    public boolean save(ZProductDTO productDTO) {
        return productMapper.insert(ZProductConvert.INSTANCE.convertDtoToEntity(productDTO)) > 0;
    }
    
    @Override
    public boolean update(ZProductDTO productDTO) {
        return productMapper.updateById(ZProductConvert.INSTANCE.convertDtoToEntity(productDTO)) > 0;
    }
    
    @Override
    public boolean removeById(Long id) {
        return productMapper.deleteById(id) > 0;
    }
    
    @Override
    public Page<ZProductVO> page(Page<ZProduct> page, ZProductDTO productDTO) {
        LambdaQueryWrapper<ZProduct> wrapper = new LambdaQueryWrapper<>();
//        wrapper.like(StringUtils.isNotBlank(productDTO.getName()), ZProduct::getName, productDTO.getName())
//              .eq(productDTO.getType() != null, ZProduct::getType, productDTO.getType())
//              .eq(productDTO.getStatus() != null, ZProduct::getStatus, productDTO.getStatus())
//              .eq(productDTO.getPrice() != null, ZProduct::getPrice, productDTO.getPrice())
//              .orderByDesc(ZProduct::getCreateTime);
              
        Page<ZProduct> productPage = productMapper.selectPage(page, wrapper);
        Page<ZProductVO> voPage = new Page<>(page.getCurrent(), page.getSize(), page.getTotal());
        voPage.setRecords(ZProductConvert.INSTANCE.convertEntityToVo(productPage.getRecords()));
        return voPage;
    }

    @Override
    public PageResult<ZProductVO> list(ZProductDTO zProductDTO) {
        Page<ZProduct> page = new Page<>(zProductDTO.getPageNo(), zProductDTO.getPageSize());

        LambdaQueryWrapper<ZProduct> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(zProductDTO.getUserId() != null , ZProduct::getUserId, zProductDTO.getUserId())
                .eq(zProductDTO.getName() != null, ZProduct::getName, zProductDTO.getName())
                .eq(zProductDTO.getStatus() != null, ZProduct::getStatus, zProductDTO.getStatus())
                .eq(zProductDTO.getFlag() != null, ZProduct::getFlag, zProductDTO.getFlag());
        IPage<ZProduct> page1 = productMapper.selectPage(page, queryWrapper);

        List<ZProductVO> zProductVOS = ZProductConvert.INSTANCE.convertEntityToVo(page1.getRecords());



        return PageUtil.createPageResult(page, zProductVOS, page1.getTotal());
    }
} 