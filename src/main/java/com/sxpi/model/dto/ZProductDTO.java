package com.sxpi.model.dto;

import com.sxpi.common.BaseEntity;
import lombok.Data;

@Data
public class ZProductDTO  extends BaseEntity {
    private Long id;
    private String name;
    private String description;
    private String images;
    private Integer status;
} 