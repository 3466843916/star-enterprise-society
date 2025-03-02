package com.sxpi.model.dto;

import com.sxpi.common.BaseEntity;
import lombok.Data;

@Data
public class ZCardFavoritesDTO extends BaseEntity {
    private Long id;
    private Long userId;
    private Long cardId;
} 