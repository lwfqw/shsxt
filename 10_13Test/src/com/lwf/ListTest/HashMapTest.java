package com.lwf.ListTest;

import java.util.*;

/**
 * @author lwf
 * @title: HashMapTest
 * @projectName 10_13Test
 * @description: TODO
 * @date 2020/10/1317:05
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<String, Set<String>> map=new HashMap<>();
        Set<String> strings=new HashSet<>();
        strings.add("qq");strings.add("腾讯");strings.add("起点");
        Set<String> strings1=new HashSet<>();
        strings1.add("阿里巴巴");strings1.add("蚂蚁金服");strings1.add("咸鱼");strings1.add("淘宝");
        Set<String> strings2=new HashSet<>();
        strings2.add("万达");
        Set<String> strings3=new HashSet<>();
        strings3.add("太极");
        map.put("马化腾", strings);
        map.put("马云", strings1);
        map.put("王健林", strings2);
        map.put("马保国", strings3);
        System.out.println("for遍历");
        for (Map.Entry entry:map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        System.out.println("迭代器遍历");
        Set iterator=map.keySet();
        Iterator iterator1=iterator.iterator();
        while (iterator1.hasNext()){
            String s= (String) iterator1.next();
            System.out.println(s+":"+map.get(s));
        }
    }
}
