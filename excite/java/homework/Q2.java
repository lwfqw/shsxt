package homework;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: lwf-pc
 * Auther: 罗卫飞
 * Date: 2020/9/28
 * 输入长宽计算长方形面积
 */
public class Q2 {
    public static double miji(double len,double wid ){
        return len*wid;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入长:");
        double len=scanner.nextDouble();
        System.out.println("输入宽:");
        double width=scanner.nextDouble();
        scanner.close();
        System.out.println("面积："+miji(len, width));
    }
}
