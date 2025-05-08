package com.sxpi.model.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.sxpi.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.sf.jsqlparser.expression.UserVariable;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author happy
 * @create 2024-04-17-{TIME}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ZUserRoleVO extends BaseEntity{
    @TableId
    private Long userId;
    private Long roleId;
    private LocalDateTime deadline;
    private ZUserVO zUserVO;
}
