package com.lwf.ThreadLearn;

/**
 * @author lwf
 * @title: Ticks
 * @projectName 10_19Code
 * @description: TODO
 * @date 2020/10/1910:23
 */
public class Ticks extends Thread{
    private static volatile int ticks;
    public Ticks(String name,int ticks) {
        super(name);
        this.ticks=ticks;
    }

    public Ticks() {
        super();
    }

    public Ticks(String name) {
        super(name);
    }

    public Ticks(int ticks) {
        this.ticks = ticks;
    }

    @Override
    public void run() {
        while (ticks>0){
            ticks--;
            System.out.println(this.getName()+"抢票成功,余"+ticks);
        }
    }

    public static void main(String[] args) {
        int ticks=100;
        //抢票1
        Ticks ticks1=new Ticks("吴彦祖",ticks);
        Ticks ticks12=new Ticks("罗卫飞");
        ticks1.start();
        ticks12.start();
        //抢票2
//        Thread thread=new Thread(new Get(100),"罗卫飞");
//        Thread thread1=new Thread(new Get(),"吴彦祖");
//        thread.start();
//        thread1.start();
    }
}
class Get implements Runnable{
    private  static int ticks;

    public Get(int ticks) {
        this.ticks = ticks;
    }
    public Get(){
        super();
    }
    @Override
    public void run() {
        while (ticks>1){
            synchronized (Get.class) {
                ticks--;
                System.out.println(Thread.currentThread().getName() + "抢票成功,余" + ticks);
            }
        }
    }
}