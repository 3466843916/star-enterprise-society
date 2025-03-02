package com.sxpi.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ZProductVO {
    private Long id;
    private String name;
    private String description;
    private String images;
    private Integer status;
    private LocalDateTime createdTime;
} 