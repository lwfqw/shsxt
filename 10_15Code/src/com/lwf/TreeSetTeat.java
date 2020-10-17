package com.lwf;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author lwf
 * @title: TreeSetTeat
 * @projectName 10_15Code
 * @description: TODO
 * @date 2020/10/1520:01
 */
public class TreeSetTeat {
    public static void main(String[] args) {
        TreeSet<String> treeSet=new TreeSet();
        treeSet.add("a");
        treeSet.add("b");
        treeSet.add("a");
        treeSet.add("c");
        Iterator<String> iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(treeSet.first());
        System.out.println(treeSet.last());
        System.out.println(treeSet.lower("a"));
    }
}
