package com.lwf.work;

import java.io.*;
import java.net.*;

/**
 * @author lwf
 * @title: UDPFileOut
 * @projectName 10_20Code
 * @description: TODO
 * @date 2020/10/2014:02
 */
public class UDPFileOut {
    public static void main(String[] args) throws SocketException, FileNotFoundException {
        Reciver reciver=new Reciver(new DatagramSocket(8989),"dist.zip");
        reciver.setDaemon(true);
        reciver.start();
        Send send=new Send(new DatagramSocket(8848), "resources/bootstrap-4.5.0-dist.zip",new InetSocketAddress("localhost",8989));
       send.start();
    }
}
class Send extends Thread {
    private DatagramSocket out;
    private BufferedInputStream inputStream;
    private InetSocketAddress des;

    public Send(DatagramSocket out, String fileStream, InetSocketAddress des) throws FileNotFoundException {
        this.out = out;
        this.inputStream = new BufferedInputStream(new FileInputStream(fileStream));
        this.des = des;
    }


    @Override
    public void run() {
        int len ;
        byte[] buf = new byte[1024*8];
        while (true) {
            try {
                if ((len = inputStream.read(buf))!= -1) {
                    out.send(new DatagramPacket(buf, len, des));
                    System.out.println("Send");
                    sleep(100);
                }
                else {
                    inputStream.close();
                    out.close();
                    return;
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Reciver extends Thread {
    private DatagramSocket out;
    private BufferedOutputStream outputStream;
    public Reciver(DatagramSocket out,String fileName) throws FileNotFoundException {
        this.out = out;
        outputStream=new BufferedOutputStream(new FileOutputStream(fileName));
    }

    @Override
    public void run() {
        while (true) {
            byte[]  buf=new byte[1024*8];
            DatagramPacket packet=new DatagramPacket(buf,buf.length);
            try {
                out.receive(packet);
                outputStream.write(buf, 0, packet.getLength());
                outputStream.flush();
                System.out.println("Reciver");
            } catch (IOException  e) {
                e.printStackTrace();
            }
        }
    }
}