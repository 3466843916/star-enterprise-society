package com.sxpi.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ZCardFavoritesVO {
    private Long id;
    private Long userId;
    private Long cardId;
    private LocalDateTime createdTime;
} 