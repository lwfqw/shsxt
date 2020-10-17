package com.lwf.多线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lwf
 * @title: ThreadPool
 * @projectName 10_16Code
 * @description: TODO
 * @date 2020/10/1621:46
 */
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(4);
        executorService.submit(new Runnable() {
            int num=10;
            @Override
            public void run() {
                while (num>=0){
                    pr(num);
                    num--;
                }
            }
        });
        executorService.submit(new Runnable() {
            int num=10;
            @Override
            public void run() {
                while (num>=0){
                    pr1(num);
                    num-=2;
                }
            }
        });
        executorService.shutdown();
    }
    public static synchronized void pr(int num){
        System.out.println("-------1");
        System.out.println(num);
    }
    public static synchronized void pr1(int num){
        System.out.println("--------2");
        System.out.println(num);
    }
}
