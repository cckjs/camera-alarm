package com.young.java.util.json;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by Administrator on 2016/1/1.
 */
public class JsonUtils {
    private static ObjectMapper mapper = new ObjectMapper();

    public static String toJson(Object obj) throws IOException {
        return mapper.writeValueAsString(obj);
    }
}
