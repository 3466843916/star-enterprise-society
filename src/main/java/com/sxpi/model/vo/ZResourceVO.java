package com.sxpi.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ZResourceVO {
    private Long id;
    private Long userId;
    private String title;
    private String content;
    private String category;
    private String region;
    private String images;
    private Integer status;
    private LocalDateTime createdTime;
} 