package com.sxpi.convert;

import com.sxpi.model.dto.ZMemberDisplayDTO;
import com.sxpi.model.entity.ZMemberDisplay;
import com.sxpi.model.vo.ZMemberDisplayVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ZMemberDisplayConvert {
    ZMemberDisplayConvert INSTANCE = Mappers.getMapper(ZMemberDisplayConvert.class);
    
    List<ZMemberDisplayVO> convertEntityToVo(List<ZMemberDisplay> memberDisplayList);
    ZMemberDisplayVO convertEntityToVo(ZMemberDisplay memberDisplay);
    
    ZMemberDisplay convertDtoToEntity(ZMemberDisplayDTO memberDisplayDTO);
    ZMemberDisplayVO convertDtoToVo(ZMemberDisplayDTO memberDisplayDTO);
} 