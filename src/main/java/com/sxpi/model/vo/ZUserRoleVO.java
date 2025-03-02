package com.sxpi.model.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.sxpi.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author happy
 * @create 2024-04-17-{TIME}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ZUserRoleVO {
    @TableId
    private Long userId;
    private Long roleId;
}
