package com.lwf.ClassTest;

import java.io.File;

/**
 * @author lwf
 * @title: FileLam
 * @projectName 10_16Code
 * @description: TODO
 * @date 2020/10/1616:13
 */
public class FileLam {
    public static void main(String[] args) {
        File file=new File("E:\\IDEA Workspace\\10_16Code");
        File[] files = file.listFiles(f -> f.isFile());
        for(File f1:files){
            System.out.println(f1.getName());
        }
    }
}
