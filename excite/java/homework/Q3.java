package homework;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: lwf-pc
 * Auther: 罗卫飞
 * Date: 2020/9/28
 * 两数最大公因数，最大公倍数
 */
public class Q3 {
    /**
     * 求两数最大公因数
     * @return
     */
    public static int bigGYS(int a,int b){
        for(int i=a;i>=1;i--){//从大到小搜索
            if(a%i==0){//为a的因数
                if(b%i==0){//a最大的因数是b的因数，找到结果
                    return i;//找到最大公因数
                }
            }
        }
        return 1;//没有找到
    }

    /**
     * 最小公倍数
     * @return  最小公倍数=两数乘积/最大公约数
     */
    public static int smallGBS(int a,int b){
        return a*b/bigGYS(a,b);
    }

    public static void main(String[] args) {
        System.out.println("依次输入两个数");
        Scanner scanner=new Scanner(System.in);
        int num1=scanner.nextInt();
        int num2=scanner.nextInt();
        scanner.close();
        System.out.println("输入了:"+num1+","+num2);
        System.out.println("最大公因数:"+bigGYS(num1,num2)+"   ,"+"最小公倍数"+smallGBS(num1,num2));
    }
}

