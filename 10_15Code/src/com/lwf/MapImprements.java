package com.lwf;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * @author lwf
 * @title: MapImprements
 * @projectName 10_15Code
 * @description: TODO
 * @date 2020/10/1515:14
 */
public class MapImprements <K,V>{

    private class Entry<K,V>{
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry<?, ?> entry = (Entry<?, ?>) o;
            return key.equals(entry.key) &&
                    value.equals(entry.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }

        @Override
        public String toString() {
            return "<" +
                    "key=" + key +
                    ", value=" + value +
                    '>';
        }
    }
    public Set<Entry> entrySet = new HashSet<>();
    public Set<K> keySet=new HashSet<>();//keySet
    public boolean push(K key,V value){
        Entry<K,V> entry=new Entry<>(key,value);
        if(keySet.add(key)){
            entrySet.add(entry);
            return true;
        }
        else
            return false;
    }
    public V getVaule(K key){
        if(keySet.contains(key)){
            for(Entry entry:entrySet){
                if(entry.key.equals(key))
                    return (V)entry.value;
            }
        }
        return null;
    }
    public Entry reMove(K key){
        Iterator iterator=entrySet.iterator();
        Entry entry;
        while (iterator.hasNext()){
            entry=(Entry) iterator.next();
            if(entry.key.equals(key)){
                iterator.remove();
                return entry;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return entrySet.toString();
    }

    public static void main(String[] args) {
        MapImprements<Integer,String> mapImprements = new MapImprements<>();
        mapImprements.push(1, "道德规范1");
        mapImprements.push(2, "道德规范2");
        mapImprements.push(3, "道德规范3");
        mapImprements.push(4, "道德规范4");
        System.out.println(mapImprements.toString());
        System.out.println(mapImprements.getVaule(2));
        System.out.println(mapImprements.reMove(4));
        System.out.println(mapImprements.toString());
    }
}
