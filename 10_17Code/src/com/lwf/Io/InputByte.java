package com.lwf.Io;

import java.io.*;
import java.util.Arrays;

/**
 * @author lwf
 * @title: InputByte
 * @projectName 10_17Code
 * @description: TODO
 * @date 2020/10/179:04
 */
public class InputByte {
    public static void read(String fileName) throws IOException {
        BufferedInputStream is=new BufferedInputStream(new FileInputStream(fileName));
        int len=-1;
        byte[] buf=new byte[1024];
        while ((len=is.read(buf))!=-1){
            //System.out.println(Arrays.toString(buf));
            System.out.println(new String(buf,0,len, "UTF-8"));
        }
    }
    public static void charRead(String file) throws IOException {
        FileReader in=new FileReader(new File(file));
        int len=-1;
        char[] buf=new char[1024];
        while ((len = in.read(buf)) != -1){
            System.out.println(new String(buf,0,len));
            //System.out.println(Arrays.toString(buf));
        }
        in.close();
    }

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
    public static void main(String[] args) throws IOException {
        //charRead("C:\\Users\\lwf\\IdeaProjects\\10_17Code\\src\\com\\lwf\\Io\\InputByte.java");
        write("1.txt");
    }
}
