package com.sxpi.model.entity;

import com.sxpi.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户优惠券表（user_coupons）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCoupon extends BaseEntity {
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
} 