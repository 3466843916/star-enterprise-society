package com.sxpi.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sxpi.common.BaseEntity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("z_card")
public class ZCard  extends BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long userId;
    private String name;
    private String position;
    private String company;
    private String contact;
    private String tags;
    private Integer status;
    private Long createdBy;
    private LocalDateTime createdTime;
    private Long updateBy;
    private LocalDateTime updateTime;
    @TableLogic
    private Integer isDeleted;
} 