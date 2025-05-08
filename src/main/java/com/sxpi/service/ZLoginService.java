package com.sxpi.service;

import com.sxpi.model.dto.Login;

/**
 * @author happy
 * @create 2025-02-19-{TIME}
 */
public interface ZLoginService {
    String getPhone(Login login);
    String getOpenid(String openIdCode);
}
