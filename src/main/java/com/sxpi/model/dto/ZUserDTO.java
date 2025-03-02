package com.sxpi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author happy
 * @create 2024-07-31-{TIME}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZUserDTO {
    private Long id;            // 用户id
    private String username;
    private String password;
    private String phone;
    private Integer gender;
    private String avatar;
}
