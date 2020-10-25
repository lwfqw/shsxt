package com.lwf.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author lwf
 * @title: Demo1
 * @projectName 10_24Code
 * @description: 流过滤懒执行：获取结果时才执行
 * @date 2020/10/2411:10
 */
public class Demo1 {
    public static void main(String[] args) {
        List<Panda> list=new ArrayList<>();
        list.add(new Panda(1,"jxa","cd"));
        list.add(new Panda(2,"jxs","cd"));
        list.add(new Panda(3,"jxd","sh"));
        list.add(new Panda(4,"jxf","cd"));
        list.stream().filter(r->r.getLocate().equals("cd")).limit(3).skip(0).forEach(c-> System.out.println(c));
        System.out.println(list.parallelStream().findAny().get());
    }
}
