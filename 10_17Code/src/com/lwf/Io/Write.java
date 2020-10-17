package com.lwf.Io;

import javax.print.StreamPrintService;
import java.io.*;

/**
 * @author lwf
 * @title: Copy
 * @projectName 10_17Code
 * @description: TODO
 * @date 2020/10/1711:35
 */
public class Write {
    /**
     * 字节缓冲流复制文件
     * @param src
     * @param des
     * @throws IOException
     */
    public static void copyByte(String src,String des)throws IOException {
        BufferedInputStream in=new BufferedInputStream(new FileInputStream(new File(src)));
        BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(new File(des)));
        int len=-1;
        byte[] buf=new byte[1024];
        while ((len=in.read(buf))!=-1){
            out.write(buf, 0, len);
        }
        out.flush();
        out.close();
        in.close();
    }

    /**
     * 字符缓冲写入
     * @param name
     * @param str
     * @throws IOException
     */
    public static void write(String name,String str) throws IOException {
        BufferedWriter out=new BufferedWriter(new FileWriter(name));
        out.write(str);
        out.newLine();
        out.flush();
        out.close();
    }
    /**
     * 字符流写入
     * @param name
     * @throws IOException
     */
    public static void write(String name) throws IOException {
        Writer ou=new FileWriter(new File(name));
        String string = new String("你好");
        String s=new String(string.getBytes("UTF-8"));
        System.out.println(s);
        s=new String(string.getBytes("gbk"),"gbk");
        System.out.println(s);
        ou.write(string+s);
        ou.close();
    }

    /**
     * 数据写入流
     * @param name
     * @throws IOException
     */
    public static void writeData(String name)throws IOException{
        DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(name));
        outputStream.writeUTF("你好");
        outputStream.writeLong(100203854L);
        outputStream.writeBoolean(true);
        outputStream.close();
    }

    /**
     * 对象流
     * @param name
     * @throws IOException
     */
    public static void objectWrite(String name,Object obj)throws IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(name));
        out.writeObject(obj);
        out.close();
    }
    public static void main(String[] args) throws IOException {
        //copyByte("resource/small1311548U2uv1600924314.jpg", "2.jpg");
        //write("1.txt", "lwf");
       // writeData("1.txt");
        objectWrite("1.txt", new Student("lwf",18));
    }
}
