package com.sxpi.model.vo;

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
public class ZBannerVO {
    // 主键id
    private Long id;

    // 图片路径
    private String img;
}
