package com.sxpi.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.BeanProperty;
import com.sxpi.common.Desensitize.Desensitize;
import com.sxpi.model.enums.DesensitizationType;
import com.sxpi.utils.DesensitizationUtils;

import java.io.IOException;

/**
 * 数据脱敏
 */
public class DesensitizeSerializer extends JsonSerializer<String> implements ContextualSerializer {

    private DesensitizationType type;

    public DesensitizeSerializer() {}

    public DesensitizeSerializer(DesensitizationType type) {
        this.type = type;
    }

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (type != null && value != null) {
            value = DesensitizationUtils.desensitize(value, type);
        }
        gen.writeString(value);
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) {
        if (property != null) {
            Desensitize annotation = property.getAnnotation(Desensitize.class);
            if (annotation != null) {
                return new DesensitizeSerializer(annotation.type());
            }
        }
        return this;
    }
}