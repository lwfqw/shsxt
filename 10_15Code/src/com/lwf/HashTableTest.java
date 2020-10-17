package com.lwf;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**
 * @author lwf
 * @title: HashTable
 * @projectName 10_15Code
 * @description: TODO
 * @date 2020/10/1519:48
 */
public class HashTableTest {
    public static void main(String[] args) {
        Hashtable<String,Integer> hashtable=new Hashtable<>();
        hashtable.put("lwf", 1);
        hashtable.put("ppl", 2);
        hashtable.put("xly", 3);
        Set<Map.Entry<String, Integer>> entries = hashtable.entrySet();
        for(Map.Entry entry:entries){
            System.out.println("<"+entry.getKey()+","+entry.getValue()+">");
        }
        System.out.println(hashtable.get("lwf"));
        System.out.println(hashtable.size());
        hashtable.remove("ppl");
        for(Map.Entry entry:entries){
            System.out.println("<"+entry.getKey()+","+entry.getValue()+">");
        }
    }
}
