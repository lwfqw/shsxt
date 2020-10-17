package com.lwf;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author lwf
 * @title: MySet
 * @projectName 10_15Code
 * @description: 手撕HashSet
 * @date 2020/10/1519:03
 */
public class MySet <T>{
    final Object object=new Object();
    private HashMap<T,Object> set;
    private int size=0;
    public MySet() {
        set=new HashMap<>();
    }
    public MySet(int size){
        set=new HashMap<>(size);
    }
    public boolean add(T t){
        if(!set.containsKey(t)){
            size++;
        }
        set.put(t, object);
        return true;
    }
    public T remove(T t){
        if(set.remove(t)!=null)
            size--;
        return t;
    }
    public int size(){return size;}
    public boolean contains(T t){ return set.containsKey(t);}
    public boolean isEmpty(){return size>0?false:false;}

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        String str = new String("[");
        Set<Map.Entry<T, Object>> entries = set.entrySet();
        for(Map.Entry entry:entries){
            str+=entry.getKey()+",";
        }
        str=str.substring(0, str.length()-1);
        return str+"]";
    }

    public static void main(String[] args) {
        MySet<Integer> set = new MySet<>();
        set.add(1);
        set.add(2);
        set.add(5);
        set.add(3);
        set.add(2);
        set.add(8);
        System.out.println(set.contains(9));
        System.out.println(set);
        System.out.println(set.remove(5));
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.isEmpty());
    }
}
