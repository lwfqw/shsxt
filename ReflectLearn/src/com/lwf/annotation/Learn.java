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
        //获取指定属性上的注解的特定值
        System.out.println(Learn.class.getDeclaredField("name").getAnnotation(MyAnnotation.class).name());
        //使用注解上的值给属性
        for (Field declaredField : Learn.class.getDeclaredFields()) {
            if (declaredField.isAnnotationPresent(MyAnnotation.class)){
                declaredField.setAccessible(true);
                if(declaredField.getType()==String.class)
                    declaredField.set(learn, declaredField.getAnnotation(MyAnnotation.class).name());
                else
                    declaredField.set(learn, declaredField.getAnnotation(MyAnnotation.class).value());
            }
        }

        System.out.println(learn);
    }
    @MyAnnotation(name = "大熊猫",value = 1)
    private int id;
    @MyAnnotation(name = "大熊猫",value = 2)
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
