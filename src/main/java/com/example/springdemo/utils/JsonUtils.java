package com.example.springdemo.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;

/**
 * JsonUtils
 *
 * @Description
 * @Author QianYiyu
 * @Date 2022/08/28 13:53
 */
public class JsonUtils {

    private static final Logger log = LoggerFactory.getLogger(JsonUtils.class);

    private final static ObjectMapper objectMapper = new ObjectMapper();

    static{
        //对象的所有字段全部列入
        objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);

        //取消默认转换timestamps形式
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        //忽略空Bean转json的错误
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        //所有的日期格式都统一为以下的样式，即yyyy-MM-dd HH:mm:ss
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        //忽略在json字符串中存在，但是在java对象中不存在对应属性的情况。防止错误
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * @description 对象转json字符串
     * @param obj 对象
     * @return java.lang.String
     * @author QianYiyu
     * @date 2020/06/02 18:43
     */
    public static <T> String obj2String(T obj) {
        if (obj == null) {
            return null;
        }
        try {
            return obj instanceof String ? (String)obj : objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            log.warn("Parse Object to String error", e);
            return null;
        }
    }

    /**
     * @description 对象转json字符串(美化)
     * @param obj 对象
     * @return java.lang.String
     * @author QianYiyu
     * @date 2020/06/02 20:07
     */
    public static <T> String obj2StringPretty(T obj) {
        if (obj == null) {
            return null;
        }
        try {
            return obj instanceof String ? (String)obj : objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (Exception e) {
            log.warn("Parse Object to String error", e);
            return null;
        }
    }

    /**
     * @description json字符串转对象
     * @param str json字符串
     * @param clazz 对象类型
     * @return T
     * @author QianYiyu
     * @date 2020/06/02 20:18
     */
    public static <T> T string2Obj(String str, Class<T> clazz) {
        if (str.isEmpty() || clazz == null) {
            return null;
        }
        try {
            return clazz.equals(String.class) ? (T)str : objectMapper.readValue(str, clazz);
        } catch (Exception e) {
            log.warn("Parse String to Object error", e);
            return null;
        }
    }

    /**
     * @description json字符串转复杂对象(Map, List, Set)
     * @param str json字符串
     * @param typeReference 对象类型
     * @return T
     * @author QianYiyu
     * @date 2020/06/02 20:24
     */
    public static <T> T string2Obj(String str, TypeReference<T> typeReference) {
        if (str.isEmpty() || typeReference == null) {
            return null;
        }
        try {
            return (typeReference.getType().equals(String.class) ? (T)str : objectMapper.readValue(str, typeReference));
        } catch (Exception e) {
            log.warn("Parse String to Object error", e);
            return null;
        }
    }

    /**
     * @description json字符串转复杂对象(嵌套)
     * @param str json字符串
     * @param collectionClass 容器类型
     * @param elementClasses 元素类型
     * @return T
     * @author QianYiyu
     * @date 2020/06/02 20:32
     */
    public static <T> T string2Obj(String str,Class<?> collectionClass,Class<?>... elementClasses){
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(collectionClass,elementClasses);
        try {
            return objectMapper.readValue(str,javaType);
        } catch (Exception e) {
            log.warn("Parse String to Object error",e);
            return null;
        }
    }
}