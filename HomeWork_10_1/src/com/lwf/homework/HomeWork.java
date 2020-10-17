package com.lwf.homework;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: lwf-pc
 * Auther: 罗卫飞
 * Date: 2020/9/29
 */
public class HomeWork {
    /**
     * 返回两个double中小值
     * @param a 传入参数1
     * @param b  传入参数1
     * @return
     */
    public static double getMin(double a,double b){
        return a>b?a:b;
    }
    public static void displayRes1(){
        Scanner scanner=new Scanner(System.in);
        double a,b;
        System.out.println("请输入第一个小数：");
        System.out.println(a=scanner.nextDouble());
        System.out.println("请输入第二个小数：");
        System.out.println(b=scanner.nextDouble());
        scanner.close();
        System.out.println(getMin(a, b));
    }

    /**
     * 求三整数最大值
     * @param a
     * @param b
     * @param c
     * @return 最大值
     */
    public static int getMax(int a,int b,int c){
        if(a>=b){
            if(b>=c){
                return a;
            }else {
                if(a>=c){
                    return a;
                }else {
                    return c;
                }
            }
        }else {
            if(a>=c){
                return b;
            }else {
                if(b>=c){
                    return b;
                }else {
                    return c;
                }
            }
        }
    }
    public static void displayRes2(){
        Scanner scanner=new Scanner(System.in);
        int a,b,c;
        System.out.println("请输入第一个整数：");
        a=scanner.nextInt();
        System.out.println("请输入第二个整数：");
        b=scanner.nextInt();
        System.out.println("请输入第三个整数：");
        c=scanner.nextInt();
        scanner.close();
        System.out.println(getMax(a, b, c));
    }

    /**
     * 通过键盘录入两个整数n和m。n代表行数，m代表列数。定义一个方法，方法的功能是打印n行m列的@符号。
     */
    public static void display(int row,int col){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print("@");
            }
            System.out.println();
        }
    }
    public static void displayRes3(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入行数：");
        int row=scanner.nextInt();
        System.out.println("请输入列数：");
        int col=scanner.nextInt();
        scanner.close();
        display(row,col);
    }

    /**
     * 我们知道数学中有九九乘法表。请定义一个方法，方法的功能是打印nn乘法表。在主方法中键盘录入
     * 取值范围为[1-9]的变量n，测试方法。
     */
    public static void display99(int num){
        if(num>9||num<0){
            System.out.println("非法输入");
            return;
        }
        for(int i=1;i<=num;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i+"*"+j+"="+(i*j)+"     ");//输出用tab隔开
            }
            System.out.println();
        }
    }
    public static void displayRes4(){
        System.out.println("请输入一个1-9之间的整数：");
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        scanner.close();
        System.out.println("乘法表");
        display99(num);
    }
    /**
     * 输入三个数，降序输出
     * @param a
     * @param b
     * @param c
     */
    public static void displayMax(int a,int b,int c){
        if(a>=b){
            if(b>=c){
                System.out.println(a+","+b+","+c);
            }else {
                if(a>=c){
                    System.out.println(a+","+c+","+b);
                }else {
                    System.out.println(c+","+a+","+b);
                }
            }
        }else {
            if(a>=c){
                System.out.println(b+","+a+","+c);
            }else {
                if(b>=c){
                    System.out.println(b+","+c+","+a);
                }else {
                    System.out.println(c+","+b+","+a);
                }
            }
        }
    }
    public static void displayRes5(){//输入3个整数调用display
        Scanner scanner=new Scanner(System.in);
        int a,b,c;
        System.out.println("请输入第一个整数：");
        a=scanner.nextInt();
        System.out.println("请输入第二个整数：");
        b=scanner.nextInt();
        System.out.println("请输入第三个整数：");
        c=scanner.nextInt();
        scanner.close();
        displayMax(a,b,c);
    }

    /**
     * 数字是有绝对值的，负数的绝对
     * 值是它本身取反，非负数的绝对值是它本身。请定义一个方法，方法能够得到小数
     * 类型数字的绝对值并返回。
     * @param a
     * @return
     */
    public static double abs(double a){
        return a>0?a:-a;
    }
    public static void displayRes6(){
        System.out.println("小数绝对值，输入一个数:");
        Scanner scanner=new Scanner(System.in);
        double a;
        System.out.println("请输入一个double数："+(a=scanner.nextDouble()));
        scanner.close();
        System.out.println(abs(a));
    }

    /**
     * 请定义一个方法，对正数的小数进行四舍五入
     * 的操作(不考虑负数情况)。四舍五入之后的结果是一个int整数类型并返回。
     * @param a 输入要四舍五入的数字
     * @return 结果
     */
    public static int cell(double a){
        return (int)(a+0.5);
    }
    public static void displayRes7(){
        Scanner scanner=new Scanner(System.in);
        double a;
        System.out.println("请输入一个正double数,四舍五入：");
        a=scanner.nextDouble();
        scanner.close();
        System.out.println(cell(a));
    }

    /**
     * 一个大V直播抽奖，奖品是现金红包，分别有{2,588,888,1000,10000}五个奖金。请使用代码
     * 模拟抽奖，打印出每个奖项，奖项的出现顺序要随机且不重复。打印效果如下：（随机顺序，不
     * 一定是下面的顺序）
     */
    public static void displayRes8(){
        int[] arr=new int[5];
        arr[0]=2;
        arr[1]=588;
        arr[2]=888;
        arr[3]=1000;
        arr[4]=10000;
        Random random=new Random();
        for(int i=0;i<5;i++){
            int index=(int)random.nextInt(5);
            System.out.println(arr[index]+"元的奖金被抽出");
        }
    }
    //主方法调用
    public static void main(String[] args) {
        displayRes8();
    }
}
