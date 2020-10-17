package com.lwf.work;

import java.io.File;
import java.io.IOException;

/**
 * @author lwf
 * @title: FileTest
 * @projectName 10_12练习
 * @description: 文件练习
 * @date 2020/10/1216:57
 */
public class FileTest {

    public static void main(String[] args) throws IOException {
        File file=new File("add/adsfg/tghgfdsd");
        file.mkdirs();
        File file1=new File(file,"a.txt");
        file1.createNewFile();
        System.out.println(delete(new File("add")));
    }
    public static boolean delete(File file){
        if(file.isFile()||(file.isDirectory()&&file.listFiles().length==0)){
           return file.delete();
        }
        for(File file1:file.listFiles()){
            delete(file1);
        }

        return file.delete();
    }

}
