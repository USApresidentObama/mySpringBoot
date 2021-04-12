package com.aixuexi.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LockKey {
    /**
     * 用在model参数前时, 需指定用作key的字段名<br>
     * e.g keyField = {"filed1", "field2", "field3"}
     *
     * @return
     */
    String[] keyField() default {};
}
