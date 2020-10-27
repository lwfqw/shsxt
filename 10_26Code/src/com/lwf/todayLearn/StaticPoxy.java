package com.lwf.todayLearn;

/**
 * @author lwf
 * @title: StaticPoxy
 * @projectName 10_26Code
 * @description: 静态代理
 * @date 2020/10/2611:28
 */
public class StaticPoxy {
    public static void main(String[] args) {
        System.out.println(StaticPoxy.getPeople("Student"));
        System.out.println(StaticPoxy.getPeople("Teacher"));
    }
    public static String getPeople(String people){
        if(people.equals("Student"))
            return new Student().canDo();
        return new Teacher().canDo();
    }
}
interface People{
    String canDo();
}
class Student implements People{

    @Override
    public String canDo() {
        return "学习";
    }
}
class Teacher implements People{
    @Override
    public String canDo() {
        return "教书";
    }
}