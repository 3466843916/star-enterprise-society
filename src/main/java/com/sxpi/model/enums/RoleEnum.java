package com.sxpi.model.enums;

import lombok.Getter;

/**
 * @author happy
 * @create 2024-08-02-{TIME}
 */
@Getter
public enum RoleEnum {
    // code对应数据库role表中id字段
    ADMIN(1,"admin"),
    USER(2,"user");

    private final Integer code;

    private final String desc;

    RoleEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
