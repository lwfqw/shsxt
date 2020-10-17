package com.lwf.homeWork;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author lwf
 * @title: QuestionTwoQQ
 * @projectName 10_14Code
 * @description: 2、现存在一些QQ号码，但其中有些是不合法的（根据规定QQ号码在[7,13]位为合法号码），甚至重复的，请提取里面的合法号码并要求没有重复的。  存入Set可实现
 *
 * String[] QQs = {"1242","123123","92391723","1231231","12335345","3242342"};
 *
 * 利用循环将合法的QQ号码进行打印
 *
 * 然后查找里面有没有你的QQ号码“12335345”， 如果有就删掉
 * @date 2020/10/1410:15
 */
public class QuestionTwoQQ {
    public static void checkQQ(String[] qq ,String myQQ){
        Set<String> all=new HashSet<>();
        for(String s:qq){//非数字或长度不符合，不合法qq
            boolean flag=true;
            if (s.length()>=7&&s.length()<=13) {
                for (char c : s.toCharArray()) {
                    if (c >= '0' && c <= '9') {
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                }
                if(flag) all.add(s);
            }
        }
        System.out.println("合法qq");
//        for (String s:all)
//            System.out.println(s);
        Iterator iterator=all.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
        if(all.contains(myQQ)){
            System.out.println("存在我的qq"+myQQ+",删除");
            System.out.println(all.remove(myQQ)+"已经删除");
        }
        //现有
        for (String s:all)
            System.out.println(s);
    }

    public static void main(String[] args) {
        String[] QQs = {"1242","123123","92391723","1231231","12335345","3242342","asfdsefgefwd"};
        checkQQ(QQs,"12335345");
    }
}
