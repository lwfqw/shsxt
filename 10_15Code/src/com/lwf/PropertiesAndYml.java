package com.lwf;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author lwf
 * @title: PropertiesAndYml
 * @projectName 10_15Code
 * @description: TODO
 * @date 2020/10/1520:17
 */
public class PropertiesAndYml {
    //读取properties
    public static void testProperties() throws IOException {
        Properties properties=new Properties();
        properties.load(PropertiesAndYml.class.getClassLoader().getResourceAsStream("1.properties"));
        System.out.println(properties.getProperty("name"));
        System.out.println(properties.getProperty("addr"));
        properties.replace("addr", "JiangXi");
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
        properties.put("qq", "519155720");
        for(Map.Entry entry:entries){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
    //读取yml
    public static void readYML() throws IOException {
        //第一种不能读取
//        Properties properties=new Properties();
//        properties.load(PropertiesAndYml.class.getClassLoader().getResourceAsStream("2.yml"));
//        System.out.println(properties.getProperty("name"));
//        System.out.println(properties.getProperty("addr"));

        //也不行
//        DataInputStream inputStream=new DataInputStream(new FileInputStream("sources/2.yml"));
//        System.out.println(inputStream.readUTF());


        BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream("sources/2.yml"),"UTF-8"));
//        char[] buf=new char[100];
//        int len=-1;
//        while ((len=reader.read(buf))!=-1){
//            System.out.println(Arrays.toString(buf));
//        }
        System.out.println(reader.readLine());
        System.out.println(reader.readLine());
        System.out.println(reader.readLine());
        System.out.println(reader.readLine());

    }
    public static void main(String[] args) throws IOException {
        testProperties();
        readYML();
    }
}
