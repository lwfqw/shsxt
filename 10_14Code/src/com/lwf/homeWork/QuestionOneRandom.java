package com.lwf.homeWork;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @author lwf
 * @title: QuestionOneRandom
 * @projectName 10_14Code
 * @description: 随机生成20个[1, 100]之间的随机整数，存入一个数组，然后取出其中大于15的整数放入一个List集合，最后利用循环在控制台上输出。
 *
 * ​	然后将集合中的奇数全部清除，只留下偶数，查看剩余的偶数以及个数
 * @date 2020/10/1410:00
 */
public class QuestionOneRandom {
    /**
     *
     * @param num   生成随机数个数
     * @param range 范围[1,range]
     */
    public static void Random(int num,int range){
        int tmp[]=new int[num];
        Random random=new Random();
        for (int i=0;i<num;i++){
            tmp[i]=random.nextInt(range)+1;
        }
        List<Integer> list=new ArrayList<>();
        for(int i:tmp){
            if(i>15)
                list.add(i);
        }
        //遍历
        System.out.println("遍历list");
//        for(int i:list){
//            System.out.println(i);
//        }
        Iterator iterator=list.listIterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
        //清除奇数
        for(int i=0;i<list.size();i++){
            if(list.get(i)%2!=0)//奇数
            {
                list.remove(i);
                i--;
            }
        }
        //遍历
        System.out.println("遍历偶数list");
//        for(int i:list){
//            System.out.println(i);
//        }
        iterator=list.listIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("还有偶数:"+list.size());
    }

    public static void main(String[] args) {
        Random(20, 100);
    }
}
