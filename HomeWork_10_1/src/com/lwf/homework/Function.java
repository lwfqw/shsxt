package com.lwf.homework;

/**
 * Created by IntelliJ IDEA.
 * User: lwf-pc
 * Auther: 罗卫飞
 * Date: 2020/9/30
 */
public class Function {
    static private int[] money=new int[4];
    public static void no(){
        System.out.println("存钱");
        System.out.println("取钱");
        System.out.println("余额");
    }
    public static void query(int i){
        System.out.println("账户"+i+":"+money[i]);
    }
    public static int out(int out,int i){
        if(money[i]>=out){
            money[i]-=out;
        }
        return (money[i]>=out)?out:0;
    }
    public static int in(int in,int i){
        money[i]+=in;
        return in;
    }

    public static void main(String[] args) {
        no();
        query(1);
        System.out.println(in(100, 1));
        System.out.println(out(80, 1));
        query(1);
    }
}
