package com.sxpi.convert;

import com.sxpi.model.dto.ZServiceDTO;
import com.sxpi.model.entity.ZService;
import com.sxpi.model.vo.ZServiceVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ZServiceConvert {
    ZServiceConvert INSTANCE = Mappers.getMapper(ZServiceConvert.class);
    
    List<ZServiceVO> convertEntityToVo(List<ZService> serviceList);
    ZServiceVO convertEntityToVo(ZService service);
    
    ZService convertDtoToEntity(ZServiceDTO serviceDTO);
    ZServiceVO convertDtoToVo(ZServiceDTO serviceDTO);
} 