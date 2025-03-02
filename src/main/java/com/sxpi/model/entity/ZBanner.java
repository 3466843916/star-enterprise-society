package com.sxpi.model.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.sxpi.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author happy
 * @create 2024-06-26-{TIME}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZBanner{
    /**
     * 主键id
     */
    private Long id;

    /**
     * 图片路径
     */
    private String img;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除（1:已删除，0：未删除）
     */
    @TableLogic
    private Integer isDeleted;
}
