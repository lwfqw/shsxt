package homework;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: lwf-pc
 * Auther: 罗卫飞
 * Date: 2020/9/28
 * 4位加密
 */
public class Q10 {
    public static int[] jiaMi(int[] num){
        int [] res=new int[4];//存放结果
        for(int i=0;i<4;i++){
            res[i]=(num[i]+5)%10;
        }
        int cur;
        cur=res[0];
        res[0]=res[3];
        res[3]=cur;//1，4交换
        cur=res[1];
        res[1]=res[2];
        res[2]=cur;//2，3交换
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入四个数：");
        int[] a=new int[4];
        a[0]=scanner.nextInt();
        a[1]=scanner.nextInt();
        a[2]=scanner.nextInt();
        a[3]=scanner.nextInt();
        System.out.println("加密后：");
        a=jiaMi(a);
        for(int i=0;i<4;i++)
            System.out.print(a[i]);
    }
}
