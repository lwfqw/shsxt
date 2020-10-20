package com.lwf.work;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

/**
 * @author lwf
 * @title: TCPClient
 * @projectName 10_20Code
 * @description: TODO
 * @date 2020/10/2015:47
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket client=new Socket("localhost",8848);
        DataOutputStream outputStream=new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
        DataInputStream input=new DataInputStream(new BufferedInputStream(client.getInputStream()));
        Scanner scanner=new Scanner(System.in);
        System.out.println("用户:");
        String user=scanner.nextLine();
        System.out.println("密码：");
        String pwd=scanner.nextLine();
        outputStream.writeUTF("user:"+user+",pwd:"+pwd);
        outputStream.flush();
        System.out.println(input.readUTF());
        input.close();
        scanner.close();
        client.close();
    }
}
