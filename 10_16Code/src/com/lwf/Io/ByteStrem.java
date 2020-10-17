package com.lwf.Io;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lwf
 * @title: ByteStrem
 * @projectName 10_16Code
 * @description: 字节流
 * @date 2020/10/1619:09
 */
public class ByteStrem {
    //Data流读取写入
    /**
     * DataInputStrem读取文件
     * @param   fileName 文件名
     * @return  文件utf-8内容
     * @throws IOException
     */
    public static String dataInputStremReadToStr(String fileName) throws IOException {
        Long now=System.currentTimeMillis();
        DataInputStream dataInputStream=new DataInputStream(new FileInputStream(new File(fileName)));
        String string = dataInputStream.readUTF();
        dataInputStream.close();
        System.out.println("字节流读取"+fileName+"耗时"+(System.currentTimeMillis()-now));
        return string;
    }

    /**
     * 读取文件到另一文件
     * @param src 源文件
     * @param des  目标文件
     * @throws IOException
     */
    public static void wrireFileToOther(File src,File des) throws IOException {
        DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(des));
        outputStream.writeUTF(dataInputStremReadToStr(src.getCanonicalPath()));
        outputStream.close();
    }
    /**
     * 写入键盘数据到文件
     * @param des  目标文件
     * @throws IOException
     */
    public static void write(File des) throws IOException {
        DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(des));
        Scanner scanner=new Scanner(System.in);
        outputStream.writeUTF(scanner.nextLine());
        scanner.close();
        outputStream.flush();
        outputStream.close();
    }
    //缓冲流读取

    /**
     * 使用缓冲流读取文件
     * @param fileName  文件名
     * @return
     */
    public static String BufferedRead(String fileName) throws IOException {
        Long now=System.currentTimeMillis();
        BufferedInputStream inputStream=new BufferedInputStream(new FileInputStream(new File(fileName)));
        String res="";
        byte[] buf=new byte[1024];
        int len=-1;
        while ((len=inputStream.read(buf))!=-1){
            res+= Arrays.toString(buf);
        }
        inputStream.close();
        System.out.println("缓冲流读取"+fileName+"耗时:"+(System.currentTimeMillis()-now));
        return res;
    }
}
