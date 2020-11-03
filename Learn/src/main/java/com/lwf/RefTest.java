package com.lwf;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author lwf
 * @title: RefTest
 * @projectName Learn
 * @description: 反射
 * @date 2020/10/2019:51
 */
public class RefTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, CloneNotSupportedException, IOException, NoSuchFieldException {
        //new对象
        Student student0 = new Student();
        student0.setName("lwf");
        student0.setAge(18);
        student0.setClassName("class 1");
        System.out.println(student0);
        Class c = Class.forName("com.lwf.Student");
        Constructor[] constructors = c.getDeclaredConstructors();
        for (Constructor c1 : constructors) {
            System.out.println(c1);
        }
        Field[] declaredFields = c.getDeclaredFields();
        System.out.println("属性");
        for (Field field : declaredFields) {
            System.out.println(field.getName() + "," + field.getType());
        }
        //修改访问权限，将私有属性直接修改值
        Field field = c.getDeclaredField("name");
        field.setAccessible(true);
        field.set(student0, "罗卫飞");
        System.out.println(student0);
        //调用方法
        Method method = c.getMethod("getName");
        System.out.println(method.invoke(student0));


        //反射获取对象
        Student student1 = (Student) c.getConstructor(String.class, Integer.class, String.class).newInstance("lwf", 18, "一班");
        Student student = (Student) c.getConstructor().newInstance();
        System.out.println(student);
        System.out.println(student1);


        //克隆对象 继承Coneable接口
        Student student2 = (Student) student1.clone();
        System.out.println(student2);

        //序列化获取对象
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("1.txt"));
        outputStream.writeObject(student);
        ObjectInputStream obj = new ObjectInputStream(new FileInputStream("1.txt"));
        Student object = (Student) obj.readObject();
        System.out.println(object);
    }
}
