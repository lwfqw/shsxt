package com.lwf.homeWork;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lwf
 * @title: MailSplite
 * @projectName 10_20Code
 * @description: 假如有以下email数据“aa@sohu.com,bb@163.com,cc@sina.com,…”现需要把email中的用户部分和邮件地址部分分离，分离后以键值对应的方式放入HashMap
 * 	结果:
 * 		key:aa   value: sohu.com
 * 		key:bb   value: sina.com
 * 	要求: 找到所有的用户信息
 * 		  找到所有的用户信息以及对应的地址信息
 * @date 2020/10/219:48
 */
public class MailSplite {
    public static void main(String[] args) {
        System.out.println(mailSplit("aa@sohu.com,bb@163.com,cc@sina.com"));
    }
    public static Map<String,String> mailSplit(String str){
        String[] str1=str.split(",");
        Map<String,String> map=new HashMap<>();
        for(String s:str1){
            if(!s.contains("@")){
                continue;
            }
            String[] tmp=s.split("@");
            map.put(tmp[0],tmp[1]);
        }
        return map;
    }
}
