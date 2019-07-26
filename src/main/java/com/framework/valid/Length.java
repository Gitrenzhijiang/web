package com.framework.valid;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 被注释的元素必须是字符串, 其长度必须在给定范围[min, max]
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Length {
    String min();
    String max();
    Class<?>[] group() default {};
    String message() default "长度必须在指定范围内";
}
