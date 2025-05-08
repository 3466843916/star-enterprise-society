package com.sxpi.model.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.sxpi.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author happy
 * @create 2024-04-17-{TIME}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ZRoleMenuDTO extends BaseEntity implements Serializable {
    @TableId
    private Long roleId;
    private Long menuId;

    private List<Long> menuIds;
}
