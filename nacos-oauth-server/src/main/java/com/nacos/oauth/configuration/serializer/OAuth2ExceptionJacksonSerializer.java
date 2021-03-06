package com.nacos.oauth.configuration.serializer;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.nacos.common.util.ServiceResponse;
import com.nacos.oauth.configuration.exception.ProOAuth2Exception;
import org.springframework.web.util.HtmlUtils;

import java.io.IOException;
import java.util.Map;

public class OAuth2ExceptionJacksonSerializer extends StdSerializer<ProOAuth2Exception> {

    protected OAuth2ExceptionJacksonSerializer() {
        super(ProOAuth2Exception.class);
    }

    @Override
    public void serialize(ProOAuth2Exception value, JsonGenerator jgen, SerializerProvider serializerProvider) throws IOException {
        jgen.writeStartObject();
        jgen.writeObjectField("status", value.getHttpErrorCode());
        String errorMessage = value.getOAuth2ErrorCode();
        if (errorMessage != null) {
            errorMessage = HtmlUtils.htmlEscape(errorMessage);
        }
        jgen.writeStringField("msg", errorMessage);
        if (value.getAdditionalInformation()!=null) {
            for (Map.Entry<String, String> entry : value.getAdditionalInformation().entrySet()) {
                String key = entry.getKey();
                String add = entry.getValue();
                jgen.writeStringField(key, add);
            }
        }
        jgen.writeEndObject();
    }
}

