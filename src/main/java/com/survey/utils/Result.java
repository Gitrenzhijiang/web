package com.survey.utils;

import java.util.HashMap;
import java.util.Map;
/**
 * service返回给 web层的对象
 *
 */
public class Result {
    private final Map<String, Object> map = new HashMap<>();
    
    public static Result of() {
        return new Result();
    }
    
    public Result put(String key, Object value) {
        map.put(key, value);
        return this;
    }
    
    public Object get(String key) {
        return map.get(key);
    }
    public Integer code() {
        return (Integer) map.get("code");
    }
    public Object data() {
        return map.get("data");
    }
    public String msg() {
        return (String) map.get("msg");
    }
    public Result code(int code) {
        put("code", code);
        return this;
    }
    public Result message(Object v) {
        put("msg", v);
        return this;
    }
    
    public Result data(Object data) {
        put("data", data);
        return this;
    }
}
