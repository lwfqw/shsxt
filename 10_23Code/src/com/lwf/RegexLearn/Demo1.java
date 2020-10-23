package com.lwf.RegexLearn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lwf
 * @title: Demo1
 * @projectName 10_23Code
 * @description: 正则表达式
 * @date 2020/10/2316:00
 */
public class Demo1 {
    public static void main(String[] args) {
        System.out.println(regexPattern("asbbc", 0, "b+c"));
        System.out.println(ipPattern("127.0.0.255"));
    }
    /**
     * 正则表达式匹配  判断字符串是否在ofset后匹配该字符，返回是否整体匹配
     * @param str
     * @param ofset
     * @param regex
     * @return
     */
    public static boolean regexPattern(String str,int ofset, String regex){
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if(matcher.find(ofset)){
            System.out.println("包含匹配项");
        }
        return matcher.matches();
    }

    /**
     * IP正确性
     * @param ip
     * @return
     */
    public static boolean ipPattern(String ip){
        return regexPattern(ip, 0,"(([0-9]|([0-9]{2})|(1[0-9]{2})|(2[0-4][0-9])|(25[0-5]))\\.){3}([0-9]|([0-9]{2})|(1[0-9]{2})|(2[0-4][0-9])|(25[0-5]))");//0-200 200-255  [0-2][0-9){2}|2[0-4][0-9]|25[0-5]
    }

}
