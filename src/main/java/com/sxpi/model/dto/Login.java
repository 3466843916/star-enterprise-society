package com.sxpi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 主要用于手机号登录的登录实体类
 * @author happy
 * @create 2025-02-19-{TIME}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login {
    private String phone;
    private String code;
    private String openIdCode;
}
