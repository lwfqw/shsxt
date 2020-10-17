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
public class Read {
    /**
     * 缓冲字节流读取
     * @param fileName
     * @throws IOException
     */
    public static void read(String fileName) throws IOException {
        BufferedInputStream is=new BufferedInputStream(new FileInputStream(fileName));
        int len=-1;
        byte[] buf=new byte[1024];
        while ((len=is.read(buf))!=-1){
            //System.out.println(Arrays.toString(buf));
            System.out.println(new String(buf,0,len, "UTF-8"));
        }
    }

    /**
     * 字符流读取
     * @param file
     * @throws IOException
     */
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

    /**
     * 字符缓冲读取
     * @param name
     * @throws IOException
     */
    public static void bufferRead(String name)throws IOException{
        BufferedReader in=new BufferedReader(new FileReader(name));
        String string;
        while (null!=(string = in.readLine())){
            System.out.println(string);
        }
    }

    /**
     * 缓冲字符包装流
     * @param name 文件名
     * @param set  编码
     * @throws IOException
     */
    public static void bufInputReader(String name ,String set) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(name)),set));
        String string;
        while(null!=(string = in.readLine())){
            System.out.println(string);
        }
        in.close();
    }

    /**
     * 数据流
     * @param name
     * @throws IOException
     */
    public static void dataInput(String name)throws IOException{
        DataInputStream inputStream = new DataInputStream(new FileInputStream(name));
        System.out.println(inputStream.readUTF());
        System.out.println(inputStream.readLong());
        System.out.println(inputStream.readBoolean());
        inputStream.close();
    }

    /**
     * 对象流
     * @param name
     * @throws IOException
     */
    public static Object objectRead(String name) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(name));
        Object object = inputStream.readObject();
        inputStream.close();
        return object;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //charRead("C:\\Users\\lwf\\IdeaProjects\\10_17Code\\src\\com\\lwf\\Io\\InputByte.java");
        //write("1.txt");
        //bufInputReader("1.txt", "UTF-8");
        //dataInput("1.txt");
        Student student=(Student)objectRead("1.txt");
        System.out.println(student.toString());

    }
}
