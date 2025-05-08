package com.sxpi.model.dto;

import com.sxpi.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单表（orders）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO extends BaseEntity {
    /**
     * 订单ID
     */
    private Long id;
    
    /**
     * 订单编号
     */
    private String orderNo;
    
    /**
     * 用户ID
     */
    private Long userId;
    
    /**
     * 商家ID
     */
    private Long merchantId;
    
    /**
     * 订单类型：1-外卖配送，2-自提
     */
    private Integer orderType;
    
    /**
     * 收货地址ID
     */
    private Long addressId;
    
    /**
     * 订单总金额
     */
    private BigDecimal totalAmount;
    
    /**
     * 配送费
     */
    private BigDecimal deliveryFee;
    
    /**
     * 优惠金额
     */
    private BigDecimal discountAmount;
    
    /**
     * 使用的优惠券ID
     */
    private Long couponId;
    
    /**
     * 实付金额
     */
    private BigDecimal actualAmount;
    
    /**
     * 订单备注
     */
    private String remark;
    
    /**
     * 订单状态：0-待支付，1-已支付待接单，2-商家已接单，3-配送中，4-已完成，5-已取消，6-已退款
     */
    private Integer status;
    
    /**
     * 支付方式：1-微信，2-支付宝，3-余额
     */
    private Integer paymentMethod;
    
    /**
     * 支付时间
     */
    private Date paymentTime;
    
    /**
     * 商家接单时间
     */
    private Date acceptTime;
    
    /**
     * 配送时间
     */
    private Date deliveryTime;
    
    /**
     * 完成时间
     */
    private Date finishTime;
    
    /**
     * 取消时间
     */
    private Date cancelTime;
    
    /**
     * 取消原因
     */
    private String cancelReason;
    
    /**
     * 配送员ID
     */
    private Long deliveryManId;
    
    /**
     * 预计送达时间
     */
    private Date expectedDeliveryTime;
    
    /**
     * 所属社区ID
     */
    private Long communityId;
} 