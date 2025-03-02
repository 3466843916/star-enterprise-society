package com.sxpi.model.dto;

import com.sxpi.common.BaseEntity;
import lombok.Data;

@Data
public class ZMemberDisplayDTO  extends BaseEntity {
    private Long id;
    private Long userId;
    private Integer type;
    private String name;
    private String description;
    private String contact;
    private Integer status;
} 