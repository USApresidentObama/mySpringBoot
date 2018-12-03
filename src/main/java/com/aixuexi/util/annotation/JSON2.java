package com.aixuexi.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by liuao on 2018/11/20.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JSON2 {
    Class<?> type(); //需要设置规则的Class
    String include() default ""; //转换时包含哪些字段
    String filter() default ""; //转换时过滤哪些字段
}
