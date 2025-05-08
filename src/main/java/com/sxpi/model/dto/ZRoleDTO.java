package com.sxpi.model.dto;

import com.sxpi.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author happy
 * @create 2025-02-15-{TIME}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZRoleDTO extends BaseEntity {
    /**
     * 角色ID
     */
    private Long id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色权限字符串
     */
    private String roleKey;

    /**
     * 角色状态(0正常，1停用)
     */

    private Integer status;
}
