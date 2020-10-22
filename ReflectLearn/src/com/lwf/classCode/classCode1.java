package com.lwf.classCode;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author lwf
 * @title: classCode
 * @projectName ReflectLearn
 * @description: TODO
 * @date 2020/10/2211:11
 */
public class classCode1 {
    public static void main(String[] args) throws Exception {
        System.out.println(Integer.class);
        System.out.println(Integer.TYPE);
        System.out.println(int.class);
//        System.out.println("qwe" instanceof String);
        //构造器
        Constructor c1=String.class.getConstructor();
        System.out.println(c1);
        System.out.println(c1.newInstance());

        String c2=String.class.getConstructor("".getClass()).newInstance("lwf");
        System.out.println(c2);

        //属性
        for(Field field:String.class.getDeclaredFields()){
            System.out.println(field);
        }
        //访问String的私用属性访问会警告但是还是会成功
        Field f=String.class.getDeclaredField("hash");
        f.setAccessible(true);
        f.set("111", 512);
        System.out.println(f.get("111"));
        System.out.println(String.class.getMethod("length").invoke("lwfxiaobai"));



        //数组
        Integer[] integers = (Integer[])Array.newInstance(Integer.class, 6);
        for(Method method:integers.getClass().getMethods()){
            System.out.println(method);
        }
        Array.set(integers, 0, 128);
        System.out.println(Array.class.getName());
        System.out.println(integers[0]);


        //Panda类测试
        Panda panda=Panda.class.getConstructor(String.class,String.class).newInstance("大头","上海");
        Field field=Panda.class.getDeclaredField("name");
        field.setAccessible(true);
        field.set(panda, "雪宝");
        System.out.println(field.get(panda));
        System.out.println(panda.getClass().getDeclaredMethod("toString").invoke(panda));
    }
}
