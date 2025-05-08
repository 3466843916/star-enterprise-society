package com.sxpi.model.vo;

import com.sxpi.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 餐品分类表（categories）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryVO extends BaseEntity {
    /**
     * 分类ID
     */
    private Long id;
    
    /**
     * 分类名称
     */
    private String categoryName;
    
    /**
     * 商家ID，NULL表示平台通用分类
     */
    private Long merchantId;
    
    /**
     * 父分类ID，0表示一级分类
     */
    private Long parentId;
    
    /**
     * 分类图标URL
     */
    private String icon;
    
    /**
     * 排序值，值越小越靠前
     */
    private Integer sortOrder;
    
    /**
     * 分类级别：1-一级分类，2-二级分类
     */
    private Integer level;
    
    /**
     * 状态：0-禁用，1-启用
     */
    private Integer status;
    
    /**
     * 分类描述
     */
    private String description;
    
    /**
     * 是否推荐：0-否，1-是
     */
    private Integer isRecommend;
    
  
} 