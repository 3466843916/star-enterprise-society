package com.sxpi.model.vo;

import com.sxpi.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 用户地址表（user_addresses）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddressVO extends BaseEntity {
    /**
     * 地址ID
     */
    private Long id;
    
    /**
     * 用户ID
     */
    private Long userId;
    
    /**
     * 社区ID
     */
    private Long communityId;
    
    /**
     * 联系人姓名
     */
    private String contactName;
    
    /**
     * 联系人电话
     */
    private String contactPhone;
    
    /**
     * 省份
     */
    private String province;
    
    /**
     * 城市
     */
    private String city;
    
    /**
     * 区县
     */
    private String district;
    
    /**
     * 详细地址
     */
    private String detailAddress;
    
    /**
     * 经度
     */
    private BigDecimal longitude;
    
    /**
     * 纬度
     */
    private BigDecimal latitude;
    
    /**
     * 是否默认地址：0-否，1-是
     */
    private Integer isDefault;
    
    /**
     * 地址标签：家、公司等
     */
    private String tag;
    
    /**
     * 门牌号
     */
    private String doorNumber;
    
    /**
     * 楼栋号
     */
    private String building;
    
    /**
     * 楼层
     */
    private String floor;
    
    /**
     * 邮政编码
     */
    private String postCode;
} 