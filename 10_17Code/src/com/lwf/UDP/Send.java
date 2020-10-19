package com.lwf.UDP;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;

/**
 * @author lwf
 * @title: Send
 * @projectName 10_17Code
 * @description: TODO
 * @date 2020/10/1720:57
 */
public class Send {
    /**
     * 发送数据包
     * @param host
     * @param port
     * @param msg
     */
    public static  void send(String host,int port,String msg,int form) throws IOException {
        SocketAddress address = new InetSocketAddress(host, port);
        byte[] buf=msg.getBytes("utf-8");
        DatagramSocket socket=new DatagramSocket(form);
        DatagramPacket packet=new DatagramPacket(buf,0,buf.length,address);
        socket.send(packet);
        socket.close();
       }

}
