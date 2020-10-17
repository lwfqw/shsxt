package com.lwf.Io;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URL;
import java.util.Arrays;

/**
 * @author lwf
 * @title: IOUtitTest
 * @projectName 10_17Code
 * @description: TODO
 * @date 2020/10/1716:48
 */
public class IOUtitTest {
    public static void main(String[] args) throws IOException {
        //字节流流复制文件
        IOUtils.copy(new FileReader(new File("1.txt")), new FileWriter(new File("2.txt")));
        //字节流复制到字符流
        IOUtils.copy(new FileInputStream("2.txt"),new FileWriter("3.txt"),"utf-8");
        //字符串转化特定编码字节流
        InputStream inputStream=IOUtils.toInputStream("lwfgg", "utf-8");
        //字节流拷贝大文件
        IOUtils.copyLarge(new FileReader(new File("1.txt")), new FileWriter(new File("2.txt")));
        //字符流转化特定缓冲的缓冲流
        BufferedReader bufferedReader = IOUtils.toBufferedReader(new FileReader(new File("1.txt")), 1024);
        //得到缓冲字符流
        BufferedReader buffer = IOUtils.buffer(new FileReader(new File("1.txt")));
        //System.out.println(buffer.readLine());
        //
        System.out.println(IOUtils.toString(new URL("https://github.com/lwfqw/shsxt"), "utf-8"));

        System.out.println(Arrays.toString(IOUtils.toByteArray(new URL("https://www.baidu.com/baidu?tn=monline_4_dg&ie=utf-8&wd=%E6%B1%9F%E8%A5%BF").openConnection())));
    }
}
