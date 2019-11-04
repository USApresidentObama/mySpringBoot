package com.aixuexi.util.annotation;

import java.lang.annotation.*;

/**
 * @author Huchuan Huang
 * @createTime 2017/3/8 下午4:59
 * @lastUpdater Huchuan Huang
 * @lastUpdateTime 2017/3/8 下午4:59
 * @note
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
//@Repeatable(JSONS.class)   // 让方法支持多重@JSON 注解
public @interface JSON {
    Class<?> type(); //需要设置规则的Class

    String include() default ""; //转换时包含哪些字段

    String filter() default ""; //转换时过滤哪些字段
}
