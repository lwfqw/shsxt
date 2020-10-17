package com.lwf.ClassTest;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lwf
 * @title: LamBa
 * @projectName 10_16Code
 * @description: TODO
 * @date 2020/10/1611:06
 */
public class LamBa {
    public static void main(String[] args) {
        A c = () -> {
            System.out.println("A");
            return 1;
        };
        c.add();


        B b= (int a1, int b2) -> {
            return a1 + b2;
        };
        System.out.println(b.add(3, 7));

        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.forEach(t-> System.out.println(2*t));
        PrintStream printStream = System.out;
        list.forEach(printStream::println);
        Map<Integer,String> map=new HashMap();
        map.put(1, "ad");
        map.put(2, "ad");
        map.put(3, "ad");
        map.forEach((k,v)-> System.out.println(k+","+v));

    }
}
interface A{
    public int add();
}
interface B{
    public int add(int a, int b);
}

