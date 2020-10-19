package com.lwf.homeWork;

import java.util.*;

/**
 * @author lwf
 * @title: TestOne
 * @projectName 10_19Code
 * @description: 1.签到
 * 	准备一个空白的本子
 * 	实现班级同学签到
 * 	键盘模拟签到
 * 	1.判断班长是否已签到
 * 	2.判断是否全员签到
 * 	注意:
 * 		1.时间限制:60 000毫秒
 * 		2.人数到了就可以结束签到
 * 		3.使用多线程实现案例
 * @date 2020/10/1919:00
 */
public class TestOne implements Runnable{
    public static void main(String[] args) {
        Thread thread=new Thread(new TestOne(), "签到");
        thread.start();
    }
    private Set<String> names=new HashSet<>();
    private Set<String> arrive=new HashSet<>();
     {
        for(int i=0;i<10;i++){
            names.add("lwf"+i);
        }
    }
    @Override
    public void run() {
        Scanner s=new Scanner(System.in);
        long start=System.currentTimeMillis();
        int arr=0;
        while (true){
            if(arr==names.size())
                return;
            synchronized (this){
            if(System.currentTimeMillis()-start<=20000&&arrive.size()!=names.size()) {
                System.out.println("签到，输入学号(0-9):");
                int id = s.nextInt();
                if (id >= 0 && id < 10) {
                    arr++;
                    arrive.add("lwf" + id);
                } else {
                    System.out.println("学号不在范围，请重新签到");
                }
            }else{
                System.out.println("签到结束");
             return;
            }
            System.out.println("是否全部签到:"+(arr==names.size()?true:false));
            System.out.println("班长lwf0是否到达:"+arrive.contains("lwf0"));
            }
        }
    }
}
