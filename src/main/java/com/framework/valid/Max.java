package com.framework.valid;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 被注释的元素必须是一个数字, 其值小于等于指定的最大值
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Max {
    String value();
    
    Class<?>[] group() default {};
    String message() default "大小必须小于等于指定值";
}
