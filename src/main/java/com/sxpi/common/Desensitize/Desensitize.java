package com.sxpi.common.Desensitize;

import com.sxpi.model.enums.DesensitizationType;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Desensitize {
    DesensitizationType type();
}