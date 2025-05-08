package com.sxpi.model.dto;

import com.sxpi.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 评价表（reviews）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO extends BaseEntity {
    /**
     * 评价ID
     */
    private Long id;
    
    /**
     * 订单ID
     */
    private Long orderId;
    
    /**
     * 用户ID
     */
    private Long userId;
    
    /**
     * 商家ID
     */
    private Long merchantId;
    
    /**
     * 订单综合评分
     */
    private BigDecimal orderRating;
    
    /**
     * 菜品评分
     */
    private BigDecimal foodRating;
    
    /**
     * 配送评分
     */
    private BigDecimal deliveryRating;
    
    /**
     * 评价内容
     */
    private String content;
    
    /**
     * 图片URL，多个用逗号分隔
     */
    private String images;
    
    /**
     * 商家回复
     */
    private String merchantReply;
    
    /**
     * 回复时间
     */
    private Date replyTime;
    
    /**
     * 是否匿名：0-否，1-是
     */
    private Integer isAnonymous;
    
    /**
     * 点赞数
     */
    private Integer likeCount;
    
    /**
     * 状态：0-待审核，1-已通过，2-已拒绝
     */
    private Integer status;
} 