package com.sxpi.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author happy
 * @create 2024-07-31-{TIME}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ZUserVO {
    private Long id;            // 用户id
    private String username;
//    private String password;
    private String phone;
    private Integer gender;
    private String avatar;
    private String token;

    private ZRoleVO role;
    private List<ZMenuVO> perms;
}
