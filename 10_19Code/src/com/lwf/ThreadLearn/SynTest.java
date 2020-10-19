package com.lwf.ThreadLearn;

/**
 * @author lwf
 * @title: SynTest
 * @projectName 10_19Code
 * @description: 同步锁资源
 * @date 2020/10/1916:44
 */
public class SynTest extends Thread{
        private static  Tick ticks=new Tick();//锁资源
        public SynTest(String name, Tick ticks) {
            super(name);
            this.ticks=ticks;
        }

        public SynTest() {
            super();
        }

        public SynTest(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true){
                synchronized (ticks) {//锁资源
                    if(ticks.num>0){
                        System.out.println(this.getName()+"买第"+ticks.num);
                         ticks.num--;
                    }
                    else
                        return;
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void main(String[] args) {
            Tick ticks=new Tick();
            ticks.num=100;
            //抢票1
            SynTest ticks1=new SynTest("吴彦祖",ticks);
            SynTest ticks2=new SynTest("罗卫飞");
            SynTest ticks3=new SynTest("永日");
            ticks1.start();
            ticks2.start();
            ticks3.start();
        }
    }

class Tick{
    int num=100;
}