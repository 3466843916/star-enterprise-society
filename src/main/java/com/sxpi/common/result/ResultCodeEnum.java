package com.sxpi.common.result;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {
    // 可以根据需求进行修改
    SUCCESS(200, "成功"),
    FAIL(201, "失败"),
    SC_UNAUTHORIZED(401, "未授权"),
    SC_FORBIDDEN(403, "权限不足"),
    EXIT_SUCCESS(300, "退出成功");

    private final Integer code;

    private final String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
