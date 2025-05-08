package com.sxpi.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户优惠券视图对象
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserCouponVO {
    /**
     * 用户优惠券ID
     */
    private Long id;
    
    /**
     * 用户ID
     */
    private Long userId;
    
    /**
     * 优惠券ID
     */
    private Long couponId;
    
    /**
     * 优惠券码
     */
    private String couponCode;
    
    /**
     * 状态：0-未使用，1-已使用，2-已过期
     */
    private Integer status;
    
    /**
     * 状态描述
     */
    private String statusDesc;
    
    /**
     * 领取时间
     */
    private Date obtainTime;
    
    /**
     * 使用时间
     */
    private Date useTime;
    
    /**
     * 使用订单ID
     */
    private Long orderId;
    
    /**
     * 优惠券名称（关联信息）
     */
    private String couponName;
    
    /**
     * 优惠券类型（关联信息）
     */
    private Integer couponType;
    
    /**
     * 优惠金额（关联信息）
     */
    private String discountAmount;
    
    /**
     * 有效期（关联信息）
     */
    private String validPeriod;
} 