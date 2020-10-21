package com.lwf.homeWork;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lwf
 * @title: TimeCalulateFromFile
 * @projectName 10_20Code
 * @description: 从文件中读入一段字符串,判断每种字符出现的次数
 * @date 2020/10/219:21
 */
public class TimeCalulateFromFile {
    public static void main(String[] args) throws IOException {
        System.out.println(getStringFromFile(TimeCalulateFromFile.class.getClassLoader().getResourceAsStream("a.txt")));
        System.out.println(getCount(getStringFromFile(TimeCalulateFromFile.class.getClassLoader().getResourceAsStream("a.txt"))));
    }
    /**
     * 文件输出utf-8字符串
     * @param fileNamae 文件名
     * @return    文件内容
     * @throws IOException
     */
    public static String getStringFromFile(InputStream fileNamae)throws IOException {
        StringBuffer stringBuffer=new StringBuffer();
        BufferedReader in=new BufferedReader(new InputStreamReader(new BufferedInputStream(fileNamae),"utf-8"));
        String add=null;
        while ((add=in.readLine())!=null){
            stringBuffer.append(add);
        }
        return String.valueOf(stringBuffer);
    }

    /**
     * 计算字符串中字符数量
     * @param str
     * @return
     */
    public static Map<Character,Integer> getCount(String str){
        str=str.replace(" ", "");
        System.out.println(str);
        Map<Character,Integer> map=new HashMap<>();
        for(char c:str.toCharArray()){
            if(map.containsKey(c)){
                map.replace(c, map.get(c), map.get(c)+1);
            }else {
                map.put(c, 1);
            }
        }
        return map;
    }
}
