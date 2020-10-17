package com.lwf.ListTest;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lwf
 * @title: Test
 * @projectName 10_13Test
 * @description: TODO
 * @date 2020/10/1310:52
 */
public class Test {
    public static void main(String[] args) {
        List<String> list=new LinkedList<>();
        list.add("熊");
        list.add("熊猫");
        list.add("狗熊");
        list.add("灰熊");

        System.out.println("remove:"+list.remove("熊"));
        System.out.println("有熊猫："+list.contains("熊猫"));
        System.out.println("改名"+list.set(1, "大熊猫"));
        System.out.println("有"+list.size()+"个");
        System.out.println(list.get(1));
        Collections.sort(list);
        System.out.println(list);
        Iterator iterator=list.listIterator();
        System.out.println("迭代器遍历");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("毕业，各分东西");
        list.clear();
        System.out.println(list);
    }
}
