package com.lwf.work;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lwf
 * @title: TCPServer
 * @projectName 10_20Code
 * @description: TODO
 * @date 2020/10/2015:52
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(8848);
        Socket client=server.accept();
        DataInputStream input=new DataInputStream(new BufferedInputStream(client.getInputStream()));
        DataOutputStream outputStream=new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
        String msg=input.readUTF();
        Map<String,String> info=new HashMap<>();
        String[]  strings = msg.split(",");
        System.out.println(msg);
        for(String string:strings){
            int in=string.indexOf(":");
            info.put(string.substring(0,in),string.substring(in+1));
        }
        int in=strings[0].indexOf(":");int in1=strings[1].indexOf(":");
        info.put(strings[0].substring(in+1),strings[1].substring(in1+1));
        outputStream.writeUTF("服务端响应:"+msg.toString()+"，信息验证："+info.get("lwf").equals("root"));
        outputStream.flush();
        outputStream.close();
        client.close();
        server.close();
    }
}
