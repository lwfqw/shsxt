package com.lwf.homeWork;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lwf
 * @title: ServerThread
 * @projectName 10_20Code
 * @description: 多线程 ServerSocket接受多个套接字并响应
 * @date 2020/10/2017:06
 */
public class ServerThread extends Thread {
    public static void main(String[] args) throws IOException {
        ServerThread serverThread=new ServerThread(new ServerSocket(8848));
        serverThread.start();

    }
    private ServerSocket server;
    private int time=0;
    public ServerThread(ServerSocket server) {
        this.server = server;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                try {
                    Socket client = server.accept();
                    time++;
                    System.out.println("当前连接数:"+time);
                    DataInputStream input = new DataInputStream(new BufferedInputStream(client.getInputStream()));
                    DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
                    String msg = input.readUTF();
                    Map<String, String> info = new HashMap<>();
                    String[] strings = msg.split(",");
                    System.out.println(msg);
                    for (String string : strings) {
                        int in = string.indexOf(":");
                        info.put(string.substring(0, in), string.substring(in + 1));
                    }
                    int in = strings[0].indexOf(":");
                    int in1 = strings[1].indexOf(":");
                    info.put(strings[0].substring(in + 1), strings[1].substring(in1 + 1));
                    outputStream.writeUTF("服务端响应:" + msg.toString() + "，信息验证：" + (info.containsKey("lwf")?info.get("lwf").equals("root"):false));
                    outputStream.flush();
                    outputStream.close();
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
