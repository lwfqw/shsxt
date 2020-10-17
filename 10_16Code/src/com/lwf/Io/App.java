package com.lwf.Io;

import java.io.File;
import java.io.IOException;

/**
 * @author lwf
 * @title: App
 * @projectName 10_16Code
 * @description: TODO
 * @date 2020/10/1619:39
 */
public class App {
    public static void main(String[] args) throws IOException {
//        //字节流
//        ByteStrem.write(new File("des.txt"));
//        System.out.println(ByteStrem.BufferedRead("des.txt"));
//        System.out.println(ByteStrem.dataInputStremReadToStr("des.txt"));
//        ByteStrem.wrireFileToOther(new File("des.txt"), new File("1.txt"));
        CharRead.write("des.txt");
        System.out.println(CharRead.read("des.txt"));
    }
}
