package com.lwf;

import com.lwf.Get;
import com.lwf.Give;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lwf
 * @title: Computer
 * @projectName noSql
 * @description: TODO
 * @date 2020/10/2816:07
 */
public class Computer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket=serverSocket.accept();
        Give give=new Give(socket);
        Get get=new Get(socket);
        get.run();
//        Thread thread=new Thread(get);
//        thread.start();
//        Thread thread1 = new Thread(give);
//        try {
//            thread1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
