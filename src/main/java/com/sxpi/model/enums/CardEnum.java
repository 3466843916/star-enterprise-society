package com.sxpi.model.enums;

import lombok.Getter;

@Getter
public enum CardEnum{
     ON_SHELVES(0,"上架"),
    UP_SHELVES(1,"下架");

    private final Integer code;

    private final String desc;

    CardEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
