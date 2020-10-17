package com.lwf.Io;

import java.awt.im.InputMethodRequests;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lwf
 * @title: CharRead
 * @projectName 10_16Code
 * @description: 缓冲流读取/写入文件
 * @date 2020/10/1620:05
 */
public class CharRead {
    public static void write(String fileName) throws IOException {
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName),"utf-8"));
        Scanner scanner=new Scanner(System.in);
        out.write(scanner.nextLine());
        scanner.close();
        out.close();
    }


    public static String read(String fileName) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String res="";
        int len=-1;
        char[] buf=new char[1024];
        while ((len=bufferedReader.read(buf))!=-1){
            char[] r=new char[len];
            System.arraycopy(buf, 0, r, 0, len);
            res+= Arrays.toString(r);
        }
        return res.substring(1, res.length()-1).replace(",", "");
    }

}
