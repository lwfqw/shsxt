package com.lwf.ZhuJie;

import java.lang.annotation.*;

/**
 * @author lwf
 * @title: Test1
 * @projectName 10_21Code
 * \]l @description: TODO
 * @date 2020/10/2115:48
 */
public class Test1 {
 @Name("lwf")
 private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
      Test1 test1=new Test1();
        System.out.println(test1.getName());
    }
}
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Name{
   public String value() default "罗卫飞";
}
