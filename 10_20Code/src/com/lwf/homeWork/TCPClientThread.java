package com.lwf.homeWork;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author lwf
 * @title: TCPClient
 * @projectName 10_20Code
 * @description: 模拟多用户同时登陆
 * @date 2020/10/2015:47
 */
public class TCPClientThread extends Thread{
    public static void main(String[] args) {
        TCPClientThread tcpClientThread = new TCPClientThread();
        tcpClientThread.start();
    }
    DataOutputStream outputStream=null;
    DataInputStream input=null;
    Socket client=null;
    public  void run() {
        for(int i=0;i<10;i++) {
            try {
                client = new Socket("localhost", 8848);
                outputStream = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
                 input= new DataInputStream(new BufferedInputStream(client.getInputStream()));
                if(i%2==0){
                    outputStream.writeUTF("user:lwf,pwd:root");
                }else {
                    outputStream.writeUTF("user:lwf"+i+",pwd:root");
                }
                outputStream.flush();
                System.out.println(input.readUTF());
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    outputStream.close();
                    input.close();
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
