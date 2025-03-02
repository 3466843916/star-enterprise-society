package com.sxpi.convert;

import com.sxpi.model.dto.ZRoleDTO;
import com.sxpi.model.entity.ZRole;
import com.sxpi.model.vo.ZRoleVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author happy
 * @create 2024-07-31-{TIME}
 */
@Mapper
public interface ZRoleConvert {
    ZRoleConvert INSTANCE = Mappers.getMapper(ZRoleConvert.class);

    ZRole convertDtoToEntity(ZRoleDTO roleDTO);

    List<ZRoleVO> convertEntityToVo(List<ZRole> roleList);

    ZRoleVO convertEntityToVo(ZRole roleList);
}
