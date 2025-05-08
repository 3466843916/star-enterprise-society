package com.sxpi.convert;

import com.sxpi.model.dto.UserCouponDTO;
import com.sxpi.model.entity.UserCoupon;
import com.sxpi.model.vo.UserCouponVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * UserCoupon转换器
 */
@Mapper
public interface UserCouponConvert {
    UserCouponConvert INSTANCE = Mappers.getMapper(UserCouponConvert.class);

    List<UserCouponVO> convertEntityToVo(List<UserCoupon> userCoupons);
    UserCouponVO convertEntityToVo(UserCoupon userCoupon);
    UserCoupon convertDtoToEntity(UserCouponDTO userCouponDTO);
} 