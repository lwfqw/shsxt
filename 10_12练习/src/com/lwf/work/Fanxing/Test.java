package com.lwf.work.Fanxing;

import java.lang.reflect.InvocationTargetException;

/**
 * @author lwf
 * @title: Test
 * @projectName 10_12练习
 * @description: 泛型练习
 * @date 2020/10/1219:19
 */
public class Test{

    public <T> boolean equal(T obj,T o) {
        if(obj==o){
            return true;
        }
        if(o==null){
            return false;
        }
        return false;
    }
    public void diaoyong(int a,int b){
        System.out.println(equal(a, b));
    }
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Zoo<Panda> zoo=new Zoo<>("上海动物园", "上海", new Panda("雪宝", 2));
        System.out.println(zoo);
        Test test=Test.class.getConstructor().newInstance();
        test.diaoyong(11, 11);
    }
}
class Animal{
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Panda{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class Panda extends Animal{
    public Panda(String name, int age) {
        super(name, age);
    }
}
class Zoo<T extends Animal>{
    private String name;
    private String place;
    private T panda;

    public Zoo(String name, String place, T panda) {
        this.name = name;
        this.place = place;
        this.panda = panda;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public T getPanda() {
        return panda;
    }

    public void setPanda(T panda) {
        this.panda = panda;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", panda=" + panda +
                '}';
    }
}