package com.lwf.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lwf
 * @title: MyAnnotation
 * @projectName ReflectLearn
 * @description: TODO
 * @date 2020/10/2216:44
 */
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    public String name() default "注解";
    public int value() default 0;
}
