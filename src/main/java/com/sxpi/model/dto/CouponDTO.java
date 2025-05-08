package com.sxpi.model.dto;

import com.sxpi.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 优惠券表（coupons）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouponDTO extends BaseEntity {
    /**
     * 优惠券ID
     */
    private Long id;
    
    /**
     * 优惠券名称
     */
    private String couponName;
    
    /**
     * 类型：1-满减券，2-折扣券，3-无门槛减免券
     */
    private Integer couponType;
    
    /**
     * 优惠金额（满减券、无门槛券）
     */
    private BigDecimal discountAmount;
    
    /**
     * 折扣率（折扣券，例如：0.8表示8折）
     */
    private BigDecimal discountRate;
    
    /**
     * 最低消费金额（满减券）
     */
    private BigDecimal minConsume;
    
    /**
     * 生效时间
     */
    private Date startTime;
    
    /**
     * 失效时间
     */
    private Date endTime;
    
    /**
     * 发行总量
     */
    private Integer totalCount;
    
    /**
     * 已使用数量
     */
    private Integer usedCount;
    
    /**
     * 每人限领数量
     */
    private Integer perLimit;
    
    /**
     * 商家ID，NULL表示平台券
     */
    private Long merchantId;
    
    /**
     * 适用范围：0-全场通用，1-指定商家，2-指定品类
     */
    private Integer applicableScope;
    
    /**
     * 适用范围ID，多个用逗号分隔
     */
    private String scopeIds;
    
    /**
     * 使用说明
     */
    private String description;
    
    /**
     * 状态：0-禁用，1-启用
     */
    private Integer status;
    
    /**
     * 优惠券图片
     */
    private String imageUrl;
} 