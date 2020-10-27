package com.lwf.todayLearn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lwf
 * @title: DyPoxy
 * @projectName 10_26Code
 * @description: 动态代理
 * @date 2020/10/2611:44
 */
public class DyPoxy {
    public static void main(String[] args) {
        Student student=new Student();
        People people= (People) Proxy.newProxyInstance(Student.class.getClassLoader(),
                Student.class.getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if(method.getName().equals("canDo")){
                            return method.invoke(student, args);
                        }
                        return null;
                    }
                });
        System.out.println(people.canDo());


        Children child=new Children();
        Father father=(Father) child;
        father.print();
    }
}
class Father{
    public void print(){
        System.out.println("father");
    }
}
class Children extends Father{
    @Override
    public void print() {
        System.out.println("children");
    }
}