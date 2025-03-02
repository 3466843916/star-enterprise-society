package com.sxpi.model.enums;

import lombok.Getter;

/**
 * @Author: codermzy
 * @Date: 2024/04/26/下午4:38
 * @Description:
 */
@Getter
public enum LikedStatusEnum {

    LIKED(1, "点赞"),
    UNLIKED(0, "取消点赞");


    private final Integer code;
    private final String desc;

    LikedStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
