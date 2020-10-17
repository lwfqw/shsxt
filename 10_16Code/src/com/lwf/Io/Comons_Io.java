package com.lwf.Io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author lwf
 * @title: Comons_Io
 * @projectName 10_16Code
 * @description: TODO
 * @date 2020/10/1620:33
 */
public class Comons_Io {
    public static void main(String[] args) throws IOException {
        File file=new File("des.txt");
//        System.out.println(FilenameUtils.getExtension("des.txt"));
//        System.out.println(FilenameUtils.getPath("des.txt"));
//        System.out.println(FilenameUtils.getBaseName("des.txt"));
//        System.out.println(FilenameUtils.getName("des.txt"));
//        System.out.println(FilenameUtils.getPrefix("des.txt"));
        System.out.println(FileUtils.readFileToString(file, "UTF-8"));
        FileUtils.writeStringToFile(file, "dfqytdfscgdftyuyfghgstuighfcgfytfghfg", "utf-8", true);
        FileUtils.copyFile(file, new File("1.txt"));
    }
}
