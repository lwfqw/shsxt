package com.lwf.annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author lwf
 * @title: LearnPlus
 * @projectName ReflectLearn
 * @description: 解析 将  MyAnnotationPlus接口值给Student的属性
 * @date 2020/10/2217:51
 */
public class LearnPlus<T> {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        System.out.println(new LearnPlus<Student>().getObject(Student.class));
    }
    /**
     * MyAnnotationPlus注解解析器
     * @param cla class对象
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     */
    public  Object getObject(Class<T> cla ) throws  IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Object obj =cla.getConstructor().newInstance();
        for (Field field : cla.getDeclaredFields()) {
            if(field.isAnnotationPresent(MyAnnotationPlus.class)){
                field.setAccessible(true);
                if(field.get(obj)==null){
                   field.set(obj, field.getAnnotation(MyAnnotationPlus.class).value());
                }
            }
        }
        return obj;
    }
}
