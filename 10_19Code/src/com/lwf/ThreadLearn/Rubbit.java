package com.lwf.ThreadLearn;

/**
 * @author lwf
 * @title: Rubbit
 * @projectName 10_19Code
 * @description: 龟兔赛跑
 * @date 2020/10/1911:10
 */
public class Rubbit implements Runnable{
    public static void main(String[] args) {
        Rubbit rubbit=new Rubbit(10, 20);
        Rubbit rubbit1=new Rubbit(3, 5);
        Thread thread=new Thread(rubbit1,"乌龟");
        Thread thread1=new Thread(rubbit,"兔子");
        thread.start();
        thread1.start();
    }
    private int all=100;
    private int speed;
    private int had=0;
    private int sleep;
    private  static boolean fin=false;
    public Rubbit(int speed,int sleep) {
        this.speed = speed;
        this.sleep=sleep;
    }

    @Override
    public void run() {
        while (true){
            synchronized (Rubbit.class) {
                if (fin) {
                    return;
                }
            }
            had += speed;
            System.out.println(Thread.currentThread().getName() + "跑了"+had+"还剩"+(all-had));
            synchronized (Rubbit.class) {
                if (had >= all) {
                    System.out.println(Thread.currentThread().getName() + "赢了");
                    fin = true;
                }
            }
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
