package homework;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: lwf-pc
 * Auther: 罗卫飞
 * Date: 2020/9/28
 * 计算发放奖金数
 */
public class Q4 {
    /**
     * 计算奖金
     * @return
     */
    public static double mery(double in){
        if(in<=10){
            return 0.1*in;
        }else if(in>10&&in<=20){
            return 10*0.1+0.075*(in-10);
        }else if(in>20&&in<=40){
            return 10*0.1+0.075*10+0.05*(in-20);
        }else if(in>40&&in<=60){
            return 10*0.1+0.075*10+0.05*20+0.03*(in-40);
        }else if(in>60&&in<=100){
            return 10*0.1+0.075*10+0.05*20+0.03*20+0.015*(in-60);
        }else if(in>100){
            return 10*0.1+0.075*10+0.05*20+0.03*20+0.015*40+0.01*(in-100);
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println("输入利润,单位万");
        Scanner scanner=new Scanner(System.in);
        System.out.println("奖励："+mery(scanner.nextDouble()));
        scanner.close();
    }
}
