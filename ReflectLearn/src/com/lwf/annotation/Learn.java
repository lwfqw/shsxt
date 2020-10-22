package com.lwf.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author lwf
 * @title: Learn
 * @projectName ReflectLearn
 * @description: TODO
 * @date 2020/10/2216:44
 */
public class Learn {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Learn learn=Learn.class.getConstructor(int.class,String.class).newInstance(16,"lwf");
        for (Annotation annotation : learn.getClass().getAnnotations()) {
            System.out.println(annotation.annotationType());
        }
        for (Field declaredField : Learn.class.getDeclaredFields()) {
            System.out.println(declaredField.getAnnotation(MyAnnotation.class).value());
            System.out.println(declaredField.getAnnotation(MyAnnotation.class).name());
        }

        System.out.println(Learn.class.getDeclaredField("id").getAnnotation(MyAnnotation.class).name());
    }
    @MyAnnotation(name = "id上注解",value = 1)
    private int id;
    @MyAnnotation(name = "Name上注解",value = 2)
    private String name;

    public Learn(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Learn{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
