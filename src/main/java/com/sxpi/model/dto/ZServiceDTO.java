package com.sxpi.model.dto;

import com.sxpi.common.BaseEntity;
import lombok.Data;

@Data
public class ZServiceDTO  extends BaseEntity {
    private Long id;
    private String name;
    private String content;
    private String images;
} 