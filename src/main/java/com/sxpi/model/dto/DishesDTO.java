package com.sxpi.model.dto;

import com.sxpi.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 菜品表（dishes）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishesDTO extends BaseEntity {
    /**
     * id
     */
    private Long id;
    /** 菜品名称 */
    private String dishName;

    /** 价格 */
    private BigDecimal price;
    private Long userId;

    /** 原价 */
    private BigDecimal originalPrice;

    /** 描述 */
    private String description;

    /** 图片URL */
    private String imageUrl;

    /** 销量 */
    private Integer sales;

    /** 月销量 */
    private Integer monthlySales;

    /** 评分 */
    private BigDecimal rating;

    /** 状态：0-下架，1-上架 */
    private Integer status;

    /** 是否推荐：0-否，1-是 */
    private Integer isRecommend;

    /** 是否辣：0-否，1-是 */
    private Integer isSpicy;
    /**备注*/
    private String remark;


}
