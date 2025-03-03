package com.sxpi.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sxpi.common.BaseEntity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("z_product")
public class ZProduct  extends BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long userId;
    private String name;
    private String description;
    private String images;
    private Integer status;
    private Integer flag;

} 