package com.sxpi.common;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sxpi.model.page.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.time.LocalDateTime;
/**
 * Entity基类
 * 
 * @author happy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Slf4j
public class BaseEntity extends PageInfo implements Serializable {
    private static final long serialVersionUID = 1L;

//    /** 搜索值 */
//    @JsonIgnore
//    private String searchValue;

    /**
     * 创建者
     */
    private Long createdBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdTime;

    /**
     * 更新者
     */
    private Long updateBy;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 是否删除（0否，1是）
     */
    @TableLogic
    private Integer isDeleted;
}

