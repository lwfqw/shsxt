package com.lwf;

/**
 * @author lwf
 * @title: ThreadLocalTest
 * @projectName 11_7MybatisGenerator
 * @description: threadlocal测试
 * @date 2020/11/1020:10
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        MyRunable runable=new MyRunable();
        new Thread(runable).start();
        new Thread(runable).start();
    }
}
class MyRunable implements Runnable{
    private ThreadLocal<Integer> local=new ThreadLocal<>();
    @Override
    public void run() {
         for(int i=0;i<3;i++){
             if(local.get()==null){
                 local.set((int) (Math.random()*100));
             }
             System.out.println(Thread.currentThread().getName()+Thread.currentThread().getId()+"ThreadLocal:"+local.get());

         }
    }
}
