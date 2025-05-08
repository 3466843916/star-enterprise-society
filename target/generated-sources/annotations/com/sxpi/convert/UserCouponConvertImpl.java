package com.sxpi.convert;

import com.sxpi.model.dto.UserCouponDTO;
import com.sxpi.model.entity.UserCoupon;
import com.sxpi.model.vo.UserCouponVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-06T04:08:48+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.15 (Microsoft)"
)
public class UserCouponConvertImpl implements UserCouponConvert {

    @Override
    public List<UserCouponVO> convertEntityToVo(List<UserCoupon> userCoupons) {
        if ( userCoupons == null ) {
            return null;
        }

        List<UserCouponVO> list = new ArrayList<UserCouponVO>( userCoupons.size() );
        for ( UserCoupon userCoupon : userCoupons ) {
            list.add( convertEntityToVo( userCoupon ) );
        }

        return list;
    }

    @Override
    public UserCouponVO convertEntityToVo(UserCoupon userCoupon) {
        if ( userCoupon == null ) {
            return null;
        }

        UserCouponVO userCouponVO = new UserCouponVO();

        userCouponVO.setId( userCoupon.getId() );
        userCouponVO.setUserId( userCoupon.getUserId() );
        userCouponVO.setCouponId( userCoupon.getCouponId() );
        userCouponVO.setCouponCode( userCoupon.getCouponCode() );
        userCouponVO.setStatus( userCoupon.getStatus() );
        userCouponVO.setObtainTime( userCoupon.getObtainTime() );
        userCouponVO.setUseTime( userCoupon.getUseTime() );
        userCouponVO.setOrderId( userCoupon.getOrderId() );

        return userCouponVO;
    }

    @Override
    public UserCoupon convertDtoToEntity(UserCouponDTO userCouponDTO) {
        if ( userCouponDTO == null ) {
            return null;
        }

        UserCoupon userCoupon = new UserCoupon();

        userCoupon.setId( userCouponDTO.getId() );
        userCoupon.setUserId( userCouponDTO.getUserId() );
        userCoupon.setCouponId( userCouponDTO.getCouponId() );
        userCoupon.setCouponCode( userCouponDTO.getCouponCode() );
        userCoupon.setStatus( userCouponDTO.getStatus() );
        userCoupon.setObtainTime( userCouponDTO.getObtainTime() );
        userCoupon.setUseTime( userCouponDTO.getUseTime() );
        userCoupon.setOrderId( userCouponDTO.getOrderId() );

        return userCoupon;
    }
}
