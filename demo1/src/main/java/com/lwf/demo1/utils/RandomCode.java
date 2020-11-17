package com.lwf.demo1.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author lwf
 * @title: RandomCode
 * @projectName demo1
 * @description: 验证码  0-9为数字，之后为大小写字母  10+26+26=62
 * @date 2020/11/1516:12
 */
@Component
public class RandomCode {
   public String get(Integer num) {
       Random random=new Random();
       String code="";
       for(int i=0;i<num;i++){
           int i1 = random.nextInt(62);
           if(i1<10){
               code+=i1;
           }else if(i1<36&&i1>9){
               code+=(char)(i1+55);
           }else {
               code+=(char)(i1+61);
           }
       }
       return code;
   }
}
