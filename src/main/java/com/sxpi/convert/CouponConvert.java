package com.sxpi.convert;

import com.sxpi.model.dto.CouponDTO;
import com.sxpi.model.entity.Coupon;
import com.sxpi.model.vo.CouponVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Coupon转换器
 */
@Mapper
public interface CouponConvert {
    CouponConvert INSTANCE = Mappers.getMapper(CouponConvert.class);

    List<CouponVO> convertEntityToVo(List<Coupon> coupons);
    CouponVO convertEntityToVo(Coupon coupon);
    Coupon convertDtoToEntity(CouponDTO couponDTO);
} 