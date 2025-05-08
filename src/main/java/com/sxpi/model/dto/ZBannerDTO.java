package com.sxpi.model.dto;

import com.sxpi.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author happy
 * @create 2024-06-26-{TIME}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZBannerDTO extends BaseEntity {
    // 主键id
    private Long id;

    // 轮播图标题
    private String title;

    // 图片路径
    private String img;

    /**
     * 是否主图（0否，1是，默认0）
     */
    private Integer isPrimary;
    private Integer sort;

}
