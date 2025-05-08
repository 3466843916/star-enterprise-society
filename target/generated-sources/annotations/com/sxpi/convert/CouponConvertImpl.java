package com.sxpi.convert;

import com.sxpi.model.dto.CouponDTO;
import com.sxpi.model.entity.Coupon;
import com.sxpi.model.vo.CouponVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-06T04:08:48+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.15 (Microsoft)"
)
public class CouponConvertImpl implements CouponConvert {

    @Override
    public List<CouponVO> convertEntityToVo(List<Coupon> coupons) {
        if ( coupons == null ) {
            return null;
        }

        List<CouponVO> list = new ArrayList<CouponVO>( coupons.size() );
        for ( Coupon coupon : coupons ) {
            list.add( convertEntityToVo( coupon ) );
        }

        return list;
    }

    @Override
    public CouponVO convertEntityToVo(Coupon coupon) {
        if ( coupon == null ) {
            return null;
        }

        CouponVO couponVO = new CouponVO();

        couponVO.setPageNo( coupon.getPageNo() );
        couponVO.setPageSize( coupon.getPageSize() );
        couponVO.setCreatedBy( coupon.getCreatedBy() );
        couponVO.setCreatedTime( coupon.getCreatedTime() );
        couponVO.setUpdateBy( coupon.getUpdateBy() );
        couponVO.setUpdateTime( coupon.getUpdateTime() );
        couponVO.setIsDeleted( coupon.getIsDeleted() );
        couponVO.setId( coupon.getId() );
        couponVO.setCouponName( coupon.getCouponName() );
        couponVO.setCouponType( coupon.getCouponType() );
        couponVO.setDiscountAmount( coupon.getDiscountAmount() );
        couponVO.setDiscountRate( coupon.getDiscountRate() );
        couponVO.setMinConsume( coupon.getMinConsume() );
        couponVO.setStartTime( coupon.getStartTime() );
        couponVO.setEndTime( coupon.getEndTime() );
        couponVO.setTotalCount( coupon.getTotalCount() );
        couponVO.setUsedCount( coupon.getUsedCount() );
        couponVO.setPerLimit( coupon.getPerLimit() );
        couponVO.setMerchantId( coupon.getMerchantId() );
        couponVO.setApplicableScope( coupon.getApplicableScope() );
        couponVO.setScopeIds( coupon.getScopeIds() );
        couponVO.setDescription( coupon.getDescription() );
        couponVO.setStatus( coupon.getStatus() );
        couponVO.setImageUrl( coupon.getImageUrl() );

        return couponVO;
    }

    @Override
    public Coupon convertDtoToEntity(CouponDTO couponDTO) {
        if ( couponDTO == null ) {
            return null;
        }

        Coupon coupon = new Coupon();

        coupon.setPageNo( couponDTO.getPageNo() );
        coupon.setPageSize( couponDTO.getPageSize() );
        coupon.setCreatedBy( couponDTO.getCreatedBy() );
        coupon.setCreatedTime( couponDTO.getCreatedTime() );
        coupon.setUpdateBy( couponDTO.getUpdateBy() );
        coupon.setUpdateTime( couponDTO.getUpdateTime() );
        coupon.setIsDeleted( couponDTO.getIsDeleted() );
        coupon.setId( couponDTO.getId() );
        coupon.setCouponName( couponDTO.getCouponName() );
        coupon.setCouponType( couponDTO.getCouponType() );
        coupon.setDiscountAmount( couponDTO.getDiscountAmount() );
        coupon.setDiscountRate( couponDTO.getDiscountRate() );
        coupon.setMinConsume( couponDTO.getMinConsume() );
        coupon.setStartTime( couponDTO.getStartTime() );
        coupon.setEndTime( couponDTO.getEndTime() );
        coupon.setTotalCount( couponDTO.getTotalCount() );
        coupon.setUsedCount( couponDTO.getUsedCount() );
        coupon.setPerLimit( couponDTO.getPerLimit() );
        coupon.setMerchantId( couponDTO.getMerchantId() );
        coupon.setApplicableScope( couponDTO.getApplicableScope() );
        coupon.setScopeIds( couponDTO.getScopeIds() );
        coupon.setDescription( couponDTO.getDescription() );
        coupon.setStatus( couponDTO.getStatus() );
        coupon.setImageUrl( couponDTO.getImageUrl() );

        return coupon;
    }
}
