package com.lwf.homeWork;

import java.util.concurrent.*;

/**
 * @author lwf
 * @title: TestTwo
 * @projectName 10_19Code      同时实现Runable,CallAble接口，分别实现以下操作
 * @description: 2. 通过2个线程实现 案例:
 * 	一个线程计算1~10000之间所有素数的和
 * 	一个线程计算10000~20000之间所有素数的个数
 * 	最终打印结果
 *
 * @date 2020/10/1919:22
 */
public class TestTwo implements Runnable, Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestTwo testTwo = new TestTwo();
        ExecutorService pool= Executors.newFixedThreadPool(2);
        pool.submit((Runnable) testTwo);
        Future future= pool.submit((Callable<Object>) testTwo);
        pool.shutdown();
        System.out.println("素数个数"+future.get());
    }
    private int sum=5;//1~10000之间所有素数的和
    private int num=0;//10000~20000之间所有素数的个数
    public static boolean judge(int i){//素数判断
        boolean flag=true;
        for(int i1 = 2;i1<=Math.sqrt(i);i1++){
            if(i%i1==0){
                return false;
            }
        }
        return flag;
    }

    /**
     * 1~10000之间所有素数的和
     */
    @Override
    public void run() {
        for (int i=4;i<10000;i++){
            if(judge(i)){
                sum+=i;
            }
        }
        System.out.println("和："+sum);
    }

    /**
     * 10000~20000之间所有素数的个数
     * @return
     * @throws Exception
     */
    @Override
    public Object call() throws Exception {
       for(int i=10000;i<=20000;i++){
           if (judge(i)){
               num++;
           }
       }
        return num;
    }
}
