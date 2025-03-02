package com.sxpi.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ZServiceVO {
    private Long id;
    private String name;
    private String content;
    private String images;
    private LocalDateTime createdTime;
} 