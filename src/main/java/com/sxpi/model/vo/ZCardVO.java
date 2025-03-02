package com.sxpi.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ZCardVO {
    private Long id;
    private Long userId;
    private String name;
    private String position;
    private String company;
    private String contact;
    private String tags;
    private Integer status;
    private LocalDateTime createdTime;
} 