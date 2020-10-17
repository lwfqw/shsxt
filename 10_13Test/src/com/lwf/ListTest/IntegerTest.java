package com.lwf.ListTest;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lwf
 * @title: IntegerTest
 * @projectName 10_13Test
 * @description: TODO
 * @date 2020/10/1311:40
 */
public class IntegerTest {
    static List<Integer> list=new ArrayList<>();
     public static int remove(Object o){
         int num=0;
         for(int i=0;i<list.size();i++){
             if(list.get(i)==o){
                 list.remove(i);
                 i--;
                 num++;
             }

         }
         return num;
     }
    public static void main(String[] args) {
        list.add(1);
        list.add(4);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        //list.remove(2);
        list.remove(new Integer(2));
        System.out.println(list);
        //删除所有
        System.out.println(remove(2));
        System.out.println(list);
    }
}
