package homework;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: lwf-pc
 * Auther: 罗卫飞
 * Date: 2020/9/28
 * 判断一个不大于五位的数字的位数并逆打出
 */
public class Q7 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();scanner.close();
        String str=a+"";
        System.out.println("共："+str.length()+"位");
        System.out.println("逆序打印");
        for(int i=str.length()-1;i>=0;i--){
            System.out.print(str.charAt(i));
        }
    }
}
