package com.sxpi.utils;

import com.sxpi.model.enums.DesensitizationType;

import static com.sxpi.model.enums.DesensitizationType.*;

/**
 * @author happy
 * @create 2025-04-15-{TIME}
 */
public class DesensitizationUtils {
    public static String desensitize(String value, DesensitizationType type) {
        switch (type) {
            case NAME:
                return value.charAt(0) + "**";
            case PHONE:
                return value.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
            case EMAIL:
                return value.replaceAll("(.{2}).*(@.*)", "$1****$2");
            case ID_CARD:
                return value.replaceAll("(\\d{4})\\d{10}(\\w{4})", "$1**********$2");
            default:
                return value;
        }
    }
}
