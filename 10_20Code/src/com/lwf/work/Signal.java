package com.lwf.work;

/**
 * @author lwf
 * @title: Signal
 * @projectName 10_20Code
 * @description: TODO
 * @date 2020/10/209:22
 */
public class Signal implements Runnable{
    public static void main(String[] args) {
        Tag tag=new Tag();
        new Thread(new Signal(tag)).start();new Thread(new Signal(tag)).start();
    }

    private static Tag sign;
    public Signal(Tag met){
        this.sign=met;
    }
    @Override
    public void run() {
        for (int i=1;i<=52;i+=2){
              synchronized (sign){
                  if(!sign.sign){
                      try {
                          sign.printNum(i);
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                      i-=2;
                  }else {
                      try {
                          sign.printA(i);
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                  }
              }
            }
        }
    }


class Tag{
      boolean sign=false;
     synchronized void printNum(int i) throws InterruptedException {
        if(sign){
            this.wait();
        }
        System.out.print(i+""+(i+1));
        sign=true;
        this.notify();
    }
    synchronized void printA(int i) throws InterruptedException {
        if(!sign){
            this.wait();
        }
        System.out.print((char)('A'+i/2));
        sign=false;
        this.notify();
    }
}