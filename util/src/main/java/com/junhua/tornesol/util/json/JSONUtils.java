package com.junhua.tornesol.util.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class JSONUtils {

    static private Logger LOG = LoggerFactory.getLogger(JSONUtils.class);

    /**
     * 将 JsonString 转换成指定对象
     *
     * @param jsonString
     * @param <T>
     * @return
     */
    public static <T> T parseJson(String jsonString, TypeReference<T> typeReference) {

        ObjectMapper objectMapper = new ObjectMapper();
        T result = null;
        try {
            result = objectMapper.readValue(jsonString.getBytes(), typeReference);
        } catch (IOException e) {
            LOG.error("exception happens while reading json ", e);
        }
        return result;
    }

    /**
     * 将对象转换成 JsonString
     *
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String toJsonString(T obj) {
        if (obj == null) return "";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            LOG.error("exception happens while writing json ", e);
            return "";
        }
    }

    /**
     * @param jsonStr
     * @param nodeName
     * @return
     */
    public static String readJsonNode(String jsonStr, String nodeName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonStr);
            JsonNode resultNode = jsonNode.findValue(nodeName);
            if (resultNode == null) return null;
            return resultNode.toString();
        } catch (IOException e) {
            LOG.error("exception happens while reading json ", e);
        }
        return null;
    }
}
