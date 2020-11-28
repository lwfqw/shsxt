package com.lwf.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author lwf
 * @title: SpringBootStart
 * @projectName 11_27Annotation
 * @description: TODO
 * @date 2020/11/2715:49
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Configuration
@ComponentScan
public @interface SpringBootStart {
    @AliasFor(
            annotation = ComponentScan.class,
            attribute ="value"
    )
    String value() default "";
}
