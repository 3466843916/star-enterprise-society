package com.sxpi.convert;

import com.sxpi.model.dto.ZMenuDTO;
import com.sxpi.model.entity.ZMenu;
import com.sxpi.model.vo.ZMenuVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author happy
 * @create 2024-07-31-{TIME}
 */
@Mapper
public interface ZMenuConvert {
    ZMenuConvert INSTANCE = Mappers.getMapper(ZMenuConvert.class);


    List<ZMenuVO> convertEntityToVo(List<ZMenu> menuList);
    ZMenu convertDtoToEntity(ZMenuDTO menuDTO);

}
