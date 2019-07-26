package com.framework.valid;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 被注释的元素必须是一个数字, 其值大于等于指定的最小值
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Min {
    String value();
    
    Class<?>[] group() default {};
    String message() default "大小必须大于等于指定值";
}
