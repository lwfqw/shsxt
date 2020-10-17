package com.lwf.Io;

import java.io.*;

/**
 * @author lwf
 * @title: Copy
 * @projectName 10_17Code
 * @description: TODO
 * @date 2020/10/1711:35
 */
public class Copy {
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
    public static void main(String[] args) throws IOException {
        copyByte("resource/small1311548U2uv1600924314.jpg", "2.jpg");
    }
}
