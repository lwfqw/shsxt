package com.lwf.homeWork;

import java.io.*;

/**
 * @author lwf
 * @title: CopyDictory
 * @projectName ReflectLearn
 * @description: 手写复制文件夹
 * @date 2020/10/2219:27
 */
public class CopyDictory {
    public static void main(String[] args) throws IOException {
        copy("work", "workCopy");
    }
    /**
     * 复制文件夹
     * @param src
     * @param des
     * @throws IOException
     */
    public static void copy(String src,String des) throws IOException {
        File srcFile=new File(src);
        File desFile=new File(des);
        copyDir(srcFile, desFile);
    }

    /**
     * 复制目录
     * @param src  源目录
     * @param des  目的目录
     * @throws IOException
     */
    public static void copyDir(File src,File des) throws IOException {
        //目的路径不存在创建目录
        if(!des.exists()){
            des.mkdir();
        }
        //拷贝目录不存在，直接结束。  源目录为空结束
        if(!src.exists()||src.listFiles().length==0){
           return;
        }
        //开始复制
        for(File file:src.listFiles()){
            if(file.isDirectory()){//是文件夹,就递归调用自己
                File file1 = new File(des, file.getName());
                file1.mkdir();
                copyDir(file, file1);
            }else {//是文件复制到目的文件夹的子目录
                copyFile(file, new File(des, file.getName()));
            }
        }
    }

    /**
     * 复制文件，简单的文件读写
     * @param file  要复制的文件
     * @param des  要复制到的父路径
     * @throws IOException
     */
    public static void copyFile(File file,File des) throws IOException {
        if(!des.exists())
            des.createNewFile();
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream writer=new BufferedOutputStream(new FileOutputStream(des));
        byte[] buf=new byte[1024*3];
        int len=-1;
        while ((len=reader.read(buf))!=-1){
            writer.write(buf, 0, len);
            writer.flush();
        }
        writer.close();
        reader.close();
    }
}
