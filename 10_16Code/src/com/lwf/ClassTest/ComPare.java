package com.lwf.ClassTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lwf
 * @title: ComPare
 * @projectName 10_16Code
 * @description: TODO
 * @date 2020/10/169:17
 */
public class ComPare {
    public static void main(String[] args) {
        List<Person> list=new ArrayList<>();
        list.add(new Person("lwf", 18, 1.88));
        list.add(new Person("psla", 18, 1.68));
        list.add(new Person("lwf1", 19, 1.88));
        list.add(new Person("lwf2", 18, 1.89));
        list.add(new Person("lwf2", 19, 1.81));
        Collections.sort(list);
        System.out.println(list);
    }
}
class Person implements Comparable<Person>{
    String name;
    int age;
    double height;

    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        //return age-o.age;

        //return (int) (height-o.height+0.5);

        //return name.compareTo(o.name);

        int res=age-o.age;
        if(res==0){
            int ag= (int) (height-o.height>0?Math.ceil(height-o.height):Math.floor(height-o.height));
            if(ag==0)
                return -name.compareTo(o.name);
            else
                return -ag;
        }else {
            return -res;
        }
    }
}