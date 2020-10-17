package homework;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: lwf-pc
 * Auther: 罗卫飞
 * Date: 2020/9/28
 * 输入三个整数从小到大输出
 */
public class Q6 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        int c=scanner.nextInt();
        scanner.close();
        if(a>=b){
            if(b>=c){
                System.out.println(c+","+b+","+a);
            }else {
                if(a>=c){
                    System.out.println(b+","+c+","+a);
                }else {
                    System.out.println(b+","+a+","+c);
                }
            }
        }else {
            if(a>=c){
                System.out.println(c+","+a+","+b);
            }else {
                if(b>=c){
                    System.out.println(a+","+c+","+b);
                }else {
                    System.out.println(a+","+b+","+c);
                }
            }
        }
    }
}
