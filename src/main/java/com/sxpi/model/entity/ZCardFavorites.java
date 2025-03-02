package com.sxpi.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sxpi.common.BaseEntity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("z_card_favorites")
public class ZCardFavorites  extends BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long userId;
    private Long cardId;
    private Long createdBy;
    private LocalDateTime createdTime;
    private Long updateBy;
    private LocalDateTime updateTime;
    @TableLogic
    private Integer isDeleted;
} 