package com.lwf.ThreadLearn;

/**
 * @author lwf
 * @title: DaoJiShi
 * @projectName 10_19Code
 * @description: 倒计时
 * @date 2020/10/1914:35
 */
public class DaoJiShi {
    public static void main(String[] args) throws InterruptedException {
//        for(int i=10;i>0;i--){
////            System.out.println(i);
////            Thread.sleep(1000);
////        }
        System.out.println(System.currentTimeMillis());
        for(int i=10;i>0;i--){
            System.out.println(i);
            Thread.currentThread().join(1000);
        }
    }
}
