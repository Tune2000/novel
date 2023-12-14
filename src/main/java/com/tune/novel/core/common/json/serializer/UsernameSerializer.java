package com.tune.novel.core.common.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @author Tune
 * @create 2023-12-13-22:41
 * @description:用户名序列化器（敏感信息，不应该在页面上完全显示）
 */
public class UsernameSerializer extends JsonSerializer<String> {
    @Override
    public void serialize(String s, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(s.substring(0, 4) + "****" + s.substring(8));
    }
}
