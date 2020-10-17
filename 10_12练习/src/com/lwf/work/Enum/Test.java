package com.lwf.work.Enum;

/**
 * @author lwf
 * @title: Test
 * @projectName 10_12练习
 * @description: 枚举练习
 * @date 2020/10/1219:54
 */
public class Test {
    public static void main(String[] args) {
        shadiao sd=shadiao.熊月行;
        switch (sd){
            case 周永日:{
                System.out.println(shadiao.周永日.getDes());break;
            }
            case 李诗海:{
                System.out.println(shadiao.李诗海.getDes());break;
            }
            case 熊月行:{
                System.out.println(shadiao.熊月行.getDes());break;
            }
            case 皮斯亮:{
                System.out.println(shadiao.皮斯亮.getDes());break;
            }
            default:{
                System.out.println(shadiao.谢亮仪.getDes());break;
            }

        }
    }
}
enum shadiao{
    皮斯亮(0,"沙雕1"),李诗海(1,"沙雕2"),熊月行(2,"沙雕3"),谢亮仪(3,"沙雕4"),周永日(4,"沙雕5");
    private int value;
    private String des;
    shadiao(int value,String des) {
        this.des=des;
        this.value=value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}