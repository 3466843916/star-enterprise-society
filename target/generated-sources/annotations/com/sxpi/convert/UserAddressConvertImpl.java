package com.sxpi.convert;

import com.sxpi.model.dto.UserAddressDTO;
import com.sxpi.model.entity.UserAddress;
import com.sxpi.model.vo.UserAddressVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-06T04:08:48+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.15 (Microsoft)"
)
public class UserAddressConvertImpl implements UserAddressConvert {

    @Override
    public List<UserAddressVO> convertEntityToVo(List<UserAddress> userAddresses) {
        if ( userAddresses == null ) {
            return null;
        }

        List<UserAddressVO> list = new ArrayList<UserAddressVO>( userAddresses.size() );
        for ( UserAddress userAddress : userAddresses ) {
            list.add( convertEntityToVo( userAddress ) );
        }

        return list;
    }

    @Override
    public UserAddressVO convertEntityToVo(UserAddress userAddress) {
        if ( userAddress == null ) {
            return null;
        }

        UserAddressVO userAddressVO = new UserAddressVO();

        userAddressVO.setPageNo( userAddress.getPageNo() );
        userAddressVO.setPageSize( userAddress.getPageSize() );
        userAddressVO.setCreatedBy( userAddress.getCreatedBy() );
        userAddressVO.setCreatedTime( userAddress.getCreatedTime() );
        userAddressVO.setUpdateBy( userAddress.getUpdateBy() );
        userAddressVO.setUpdateTime( userAddress.getUpdateTime() );
        userAddressVO.setIsDeleted( userAddress.getIsDeleted() );
        userAddressVO.setId( userAddress.getId() );
        userAddressVO.setUserId( userAddress.getUserId() );
        userAddressVO.setCommunityId( userAddress.getCommunityId() );
        userAddressVO.setContactName( userAddress.getContactName() );
        userAddressVO.setContactPhone( userAddress.getContactPhone() );
        userAddressVO.setProvince( userAddress.getProvince() );
        userAddressVO.setCity( userAddress.getCity() );
        userAddressVO.setDistrict( userAddress.getDistrict() );
        userAddressVO.setDetailAddress( userAddress.getDetailAddress() );
        userAddressVO.setLongitude( userAddress.getLongitude() );
        userAddressVO.setLatitude( userAddress.getLatitude() );
        userAddressVO.setIsDefault( userAddress.getIsDefault() );
        userAddressVO.setTag( userAddress.getTag() );
        userAddressVO.setDoorNumber( userAddress.getDoorNumber() );
        userAddressVO.setBuilding( userAddress.getBuilding() );
        userAddressVO.setFloor( userAddress.getFloor() );
        userAddressVO.setPostCode( userAddress.getPostCode() );

        return userAddressVO;
    }

    @Override
    public UserAddress convertDtoToEntity(UserAddressDTO userAddressDTO) {
        if ( userAddressDTO == null ) {
            return null;
        }

        UserAddress userAddress = new UserAddress();

        userAddress.setPageNo( userAddressDTO.getPageNo() );
        userAddress.setPageSize( userAddressDTO.getPageSize() );
        userAddress.setCreatedBy( userAddressDTO.getCreatedBy() );
        userAddress.setCreatedTime( userAddressDTO.getCreatedTime() );
        userAddress.setUpdateBy( userAddressDTO.getUpdateBy() );
        userAddress.setUpdateTime( userAddressDTO.getUpdateTime() );
        userAddress.setIsDeleted( userAddressDTO.getIsDeleted() );
        userAddress.setId( userAddressDTO.getId() );
        userAddress.setUserId( userAddressDTO.getUserId() );
        userAddress.setCommunityId( userAddressDTO.getCommunityId() );
        userAddress.setContactName( userAddressDTO.getContactName() );
        userAddress.setContactPhone( userAddressDTO.getContactPhone() );
        userAddress.setProvince( userAddressDTO.getProvince() );
        userAddress.setCity( userAddressDTO.getCity() );
        userAddress.setDistrict( userAddressDTO.getDistrict() );
        userAddress.setDetailAddress( userAddressDTO.getDetailAddress() );
        userAddress.setLongitude( userAddressDTO.getLongitude() );
        userAddress.setLatitude( userAddressDTO.getLatitude() );
        userAddress.setIsDefault( userAddressDTO.getIsDefault() );
        userAddress.setTag( userAddressDTO.getTag() );
        userAddress.setDoorNumber( userAddressDTO.getDoorNumber() );
        userAddress.setBuilding( userAddressDTO.getBuilding() );
        userAddress.setFloor( userAddressDTO.getFloor() );
        userAddress.setPostCode( userAddressDTO.getPostCode() );

        return userAddress;
    }
}
