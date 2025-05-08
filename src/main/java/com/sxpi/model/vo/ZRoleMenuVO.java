package com.sxpi.model.vo;

import com.baomidou.mybatisplus.annotation.TableId;
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
public class ZRoleMenuVO implements Serializable {
    @TableId
    private Long roleId;
    private Long menuId;
}
