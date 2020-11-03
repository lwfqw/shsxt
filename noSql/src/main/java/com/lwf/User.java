package com.lwf;

import java.io.IOException;
import java.net.Socket;

/**
 * @author lwf
 * @title: User
 * @projectName noSql
 * @description: TODO
 * @date 2020/10/2816:07
 */
public class User {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket=new Socket("127.0.0.1", 9999);
        Give give=new Give(socket);
        Get get=new Get(socket);
        give.run();
//        Thread thread=new Thread(get);
//        thread.join();
//        thread.start();
//        new Thread(give).start();
    }
}
