package com.lwf.多线程;

/**
 * @author lwf
 * @title: ThreadTest
 * @projectName 10_16Code
 * @description: TODO
 * @date 2020/10/1620:53
 */
public class ThreadTest {
    public static void main(String[] args) {
        Tran tran=new Tran(50);
        Runnable thread=new Runnable(){
            @Override
            public void run() {
                while (tran.has()){
                    synchronized (Tran.class){
                        System.out.println("---------------");
                        System.out.println(this.getClass());
                        System.out.println("抢票,还有"+tran.getNumber());
                        tran.setNumber(tran.getNumber()-1);
                    }
                }
            }
        };
       new Thread(thread).start();
       new MyThread(tran).start();
    }
}
class MyThread extends Thread{
    private Tran tran;
    public MyThread(){}
    public MyThread(Tran tran) {
        this.tran = tran;
    }

    @Override
    public void run() {
        synchronized (Tran.class){
            System.out.println("---------------");
            System.out.println(this.getClass());
            System.out.println("抢票");
            tran.setNumber(tran.getNumber()-1);
        }
    }
}
class Tran{
    private int number;
     public boolean has(){
         return number>0?true:false;
     }
    public Tran(int i) {
        number=i;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}