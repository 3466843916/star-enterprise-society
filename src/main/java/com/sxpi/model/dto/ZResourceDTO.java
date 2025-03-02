package com.sxpi.model.dto;

import com.sxpi.common.BaseEntity;
import lombok.Data;

@Data
public class ZResourceDTO  extends BaseEntity {
    private Long id;
    private Long userId;
    private String title;
    private String content;
    private String category;
    private String region;
    private String images;
    private Integer status;
} 