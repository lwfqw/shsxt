package com.lwf.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lwf
 * @title: MyAnnotationPlus
 * @projectName ReflectLearn
 * @description: TODO
 * @date 2020/10/2217:47
 */
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotationPlus {
    public String value() default "lwf";
}
