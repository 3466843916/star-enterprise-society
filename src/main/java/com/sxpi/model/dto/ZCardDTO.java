package com.sxpi.model.dto;

import com.sxpi.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ZCardDTO extends BaseEntity {
    private Long id;
    private Long userId;
    private String name;
    private String position;
    private String company;
    private String contact;
    private String tags;
    private Integer status;
} 