package com.sxpi.convert;

import com.sxpi.model.dto.ZProductDTO;
import com.sxpi.model.entity.ZProduct;
import com.sxpi.model.vo.ZProductVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ZProductConvert {
    ZProductConvert INSTANCE = Mappers.getMapper(ZProductConvert.class);
    
    List<ZProductVO> convertEntityToVo(List<ZProduct> productList);
    ZProductVO convertEntityToVo(ZProduct product);
    
    ZProduct convertDtoToEntity(ZProductDTO productDTO);
    ZProductVO convertDtoToVo(ZProductDTO productDTO);
} 