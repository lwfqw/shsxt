package com.lwf.UDP;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

/**
 * @author lwf
 * @title: Chatroom
 * @projectName 10_17Code
 * @description: 聊天室
 * @date 2020/10/1721:26
 */
public class Chatroom {
    public static void main(String[] args) throws IOException {
        User u1=new User("lwf",8080,9000);
        User u2=new User("ppl",9000,8080);
        u1.start();
        u2.start();
    }
}
class User extends Thread{
    private static Scanner scanner;
    private static Lock lock;
    private int from;
    private  int to;
    private static int time=0;
    static {
        scanner=new Scanner(System.in);
        lock=new ReentrantLock();
    }

    public User(String name) {
        super(name);
    }

    public User(String name, int from, int t0) {
        super(name);
        this.from = from;
        this.to = t0;
    }

    @Override
    public void run() {
        while (true){

                lock.lock();
                System.out.println("请秀儿发炎:" + this.getName());
                System.out.println("输入dui对方ip:");
                String ip = scanner.nextLine();
                System.out.println("请开始你的表演：");
                String msg = scanner.nextLine();
                try {
                    Send.send(ip, to, msg,from);
                    lock.unlock();
                    //Thread.sleep(500);
                    if(time++!=0)
                        Reciver.reciver(from);
                    else
                        System.out.println("抛砖引玉");
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
    }
}