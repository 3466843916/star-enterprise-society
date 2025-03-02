package com.sxpi.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ZMemberDisplayVO {
    private Long id;
    private Long userId;
    private Integer type;
    private String name;
    private String description;
    private String contact;
    private Integer status;
    private LocalDateTime createdTime;
} 