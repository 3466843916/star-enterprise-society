package com.sxpi.model.enums;

import lombok.Getter;

/**
 * @Author: codermzy
 * @Date: 2024/03/11/19:15
 * @Description:
 */
@Getter
public enum IsDeletedEnum {

    DELETE(1,"删除"),
    UN_DELETE(0,"未删除");

    private final Integer code;

    private final String desc;

    IsDeletedEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
