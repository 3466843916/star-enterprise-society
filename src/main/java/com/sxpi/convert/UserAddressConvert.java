package com.sxpi.convert;

import com.sxpi.model.dto.UserAddressDTO;
import com.sxpi.model.entity.UserAddress;
import com.sxpi.model.vo.UserAddressVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * UserAddress转换器
 */
@Mapper
public interface UserAddressConvert {
    UserAddressConvert INSTANCE = Mappers.getMapper(UserAddressConvert.class);

    List<UserAddressVO> convertEntityToVo(List<UserAddress> userAddresses);
    UserAddressVO convertEntityToVo(UserAddress userAddress);
    UserAddress convertDtoToEntity(UserAddressDTO userAddressDTO);
} 