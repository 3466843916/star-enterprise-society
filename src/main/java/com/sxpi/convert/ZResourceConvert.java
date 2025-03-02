package com.sxpi.convert;

import com.sxpi.model.dto.ZResourceDTO;
import com.sxpi.model.entity.ZResource;
import com.sxpi.model.vo.ZResourceVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ZResourceConvert {
    ZResourceConvert INSTANCE = Mappers.getMapper(ZResourceConvert.class);
    
    List<ZResourceVO> convertEntityToVo(List<ZResource> resourceList);
    ZResourceVO convertEntityToVo(ZResource resource);
    
    ZResource convertDtoToEntity(ZResourceDTO resourceDTO);
    ZResourceVO convertDtoToVo(ZResourceDTO resourceDTO);
} 