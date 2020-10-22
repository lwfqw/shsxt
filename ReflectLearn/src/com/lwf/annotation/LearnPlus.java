package com.lwf.annotation;

import jdk.dynalink.beans.StaticClass;

import java.lang.reflect.Field;

/**
 * @author lwf
 * @title: LearnPlus
 * @projectName ReflectLearn
 * @description: 解析 将  MyAnnotationPlus接口值给Student的属性
 * @date 2020/10/2217:51
 */
public class LearnPlus<T> {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Student student=Student.class.newInstance();
        new LearnPlus<Student>().getObject("com.lwf.annotation.Student",student);
        System.out.println(student);
    }
    /**
     * MyAnnotationPlus注解解析器
     * @param str
     * @param obj
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     */
    public  boolean getObject(String str,T obj) throws ClassNotFoundException, IllegalAccessException {
        Class c= Class.forName(str);
        for (Field field : c.getDeclaredFields()) {
            if(field.isAnnotationPresent(MyAnnotationPlus.class)){
                field.setAccessible(true);
                if(field.get(obj)==null){
                   field.set(obj, field.getAnnotation(MyAnnotationPlus.class).value());
                }
            }
        }
        return true;
    }
}
