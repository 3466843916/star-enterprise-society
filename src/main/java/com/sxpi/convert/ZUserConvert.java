package com.sxpi.convert;

import com.sxpi.model.dto.ZUserDTO;
import com.sxpi.model.entity.ZUser;
import com.sxpi.model.vo.ZUserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author happy
 * @create 2024-07-31-{TIME}
 */
@Mapper
public interface ZUserConvert {
    ZUserConvert INSTANCE = Mappers.getMapper(ZUserConvert.class);

    List<ZUserVO> convertEntityToVo(List<ZUser> userList);
    ZUserVO convertEntityToVo(ZUser user);

    ZUser convertDtoToEntity(ZUserDTO userDTO);
    ZUserVO convertDtoToVo(ZUserDTO userDTO);
    ZUser convertVoToEntity(ZUserVO userVO);
}
