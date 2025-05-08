package com.sxpi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author happy
 * @create 2024-08-02-{TIME}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZLogin {
    private String phone;
    private String code;
    private String openIdCode;
}
