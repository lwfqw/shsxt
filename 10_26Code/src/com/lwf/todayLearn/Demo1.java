package com.lwf.todayLearn;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static java.lang.Thread.sleep;

/**
 * @author lwf
 * @title: Demo1
 * @projectName 10_26Code
 * @description: 单例模式：饿汉，懒汉    反射直接绕过单例检查
 * @date 2020/10/2610:15
 */
public class Demo1 {
    public static void main(String[] args) {
        Runnable runnable=()->{
          for(int i=0;i<20;i++){
              System.out.println(Single.getSingle());
          }
        };
        Runnable runnable1=()->{
            for(int i=0;i<20;i++){
                System.out.println(Single1.getSingle1());
            }
        };
        new Thread(runnable).start();
        new Thread(runnable).start();
        //new Thread(runnable1).start();
        //new Thread(runnable1).start();
        try {
            Constructor<Single> declaredConstructor = Single.class.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            System.out.println(declaredConstructor.newInstance());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
//饿汉
class Single{
    private static Single single=new Single();

    private Single() {
        System.out.println("构造器");
    }
    public static Single getSingle(){
        try {
            sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return single;
    }
}
//懒汉
class Single1{
    private static Single1 single1=null;
    private Single1(){System.out.println("构造器");}
    public static synchronized Single1 getSingle1(){
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(single1!=null)
            return single1;
        single1=new Single1();
        return single1;
    }
}