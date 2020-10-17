package com.lwf.ListTest;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author lwf
 * @title: SetTest
 * @projectName 10_13Test
 * @description: TODO
 * @date 2020/10/1316:26
 */
public class SetTest {
    public static void main(String[] args) {
        Set<Student> set=new HashSet<>();
        set.add(new Student("lwf", 18));
        set.add(new Student("lwq", 19));
        set.add(new Student("lwq", 19));
        System.out.println(set);
        for (Student student :set){
            System.out.println(student);
        }
        System.out.println("-------------");
        Iterator iterator=set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
