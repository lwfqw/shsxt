package com.lwf.Thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lwf
 * @title: LockThread
 * @projectName 10_17Code
 * @description: lock的运用
 * @date 2020/10/1720:33
 */
public class LockThread {
    public static void main(String[] args) {
        Thread t1=new Thread(new Lock(10),"线程1");
        Thread t2=new Thread(new Lock(),"线程2");
        t1.start();
        t2.start();
    }
}
class Lock implements Runnable{
    private static int number;
    private static java.util.concurrent.locks.Lock lock;
    static {
        lock=new ReentrantLock();
    }
    public Lock(int number) {
        this.number = number;
    }

    public Lock() {
    }

    @Override
    public void run() {
        while (number>0){
            //线程执行到这里时，下一个线程会进入while等待，虽然number规定大于0执行，这里会多执行，但是number的修改
            //每次只能由一个线程访问
            lock.lock();
            System.out.println(number+",减一:"+(--number));
            System.out.println("释放锁");
            lock.unlock();
        }
    }
}