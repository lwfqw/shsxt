package com.lwf.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author lwf
 * @title: Reciver
 * @projectName 10_17Code
 * @description: TODO
 * @date 2020/10/1721:09
 */
public class Reciver {
    /**
     * 接受指定端口数据
     * @param port
     * @throws IOException
     */
    public static void reciver(int port) throws IOException {
        DatagramSocket rec=new DatagramSocket(port);
        DatagramPacket res=new DatagramPacket(new byte[1024], 1024);
        rec.receive(res);
        System.out.println(rec.getLocalAddress()+"收到来自："+res.getSocketAddress()+"的问候");
        System.out.println(new String(res.getData(),0,res.getLength(),"utf-8"));
        rec.close();
    }

    public static void main(String[] args) throws IOException {
        reciver(8080);
    }
}
