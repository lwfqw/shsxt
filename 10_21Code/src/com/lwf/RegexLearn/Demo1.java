package com.lwf.RegexLearn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lwf
 * @title: Demo1
 * @projectName 10_21Code
 * @description: TODO
 * @date 2020/10/2116:03
 */
public class Demo1 {
    public static void main(String[] args) {
        String str1="127.124.235.001";
        //简单匹配检查ip
        System.out.println(str1.matches("\\d{1,3}(.\\d{1,3}){3}"));
        //0-255  ([01]\\d{2})|2([0-4]\\d)|25[0-5]      (([01]\d{2})|2([0-4]\d)|25[0-5])(.(([01]\d{2})|2([0-4]\d)|25[0-5])){3}
        //只能匹配 0-255.0-255.0-255.0-255   且127.0.0.1必须写成127.000.000.001不然无法识别
        System.out.println(str1.matches("(([01]\\d{2})|2([0-4]\\d)|25[0-5])(.(([01]\\d{2})|2([0-4]\\d)|25[0-5])){3}"));
        //Pattern ，Matcher 匹配字符串
        //Pattern 调用compile（）方法传入正则表达式
        //获取到的Pattern对象调用matcher（）传入要分析的字符串
        //调用get（）方法获取是否匹配，参数表示从哪个索引开始查找默认0
        String str2="江西上饶beautiful";
        Pattern p=Pattern.compile("上");
        Matcher matcher=p.matcher(str2);
        System.out.println(matcher.find(2));

    }
}
