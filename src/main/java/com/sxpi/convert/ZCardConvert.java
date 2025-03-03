package com.sxpi.convert;

import com.sxpi.model.dto.ZCardDTO;
import com.sxpi.model.entity.ZCard;
import com.sxpi.model.vo.ZCardVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ZCardConvert {
    ZCardConvert INSTANCE = Mappers.getMapper(ZCardConvert.class);

    List<ZCardVO> convertEntityToVo(List<ZCard> cardList);
    ZCardVO convertEntityToVo(ZCard card);

    ZCard convertDtoToEntity(ZCardDTO cardDTO);
    ZCardVO convertDtoToVo(ZCardDTO cardDTO);

    ZCard convertVoToEntity(ZCardVO cardVO);
    // 添加将 ZCard 转换为 ZCardDTO 的方法
    ZCardDTO convertEntityToDto(ZCard zCard);
}