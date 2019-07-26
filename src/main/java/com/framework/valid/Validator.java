package com.framework.valid;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.survey.pojo.User;

public class Validator {
    public static void main(String[] args) {
        User u = new User();u.setName("a");u.setId(2);
        
        validate(u);
    }
    /**
     * 验证
     * @param obj
     * @param groups
     * @return
     */
    public static<T> Map<String, String> validate(T obj, Class...groups) {
        // 注解中 group 包含 groups, 则校验.
        try {
            BeanUtils.describe(obj).entrySet()
                .stream().forEach(e -> {
                    
                });
            
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
