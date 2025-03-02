package com.sxpi.model.entity;

import com.sxpi.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author happy
 * @create 2024-04-17-{TIME}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZMenu extends BaseEntity {
    private Integer id;
    private String menuName;
    private String path;
    private String component;
    private Character status;
    private String perms;
}
