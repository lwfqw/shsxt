package work;

import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: lwf-pc
 * Auther: 罗卫飞
 * Date: 2020/9/28
 * 生成随机数到88停止
 */
public class RandomTo88 {
    public static void random(){
        Random random=new Random();
        int i;
        while (true){
           i=random.nextInt(100) ;
            System.out.println("生成随机数:"+i);
            if(i==88){
                System.out.println("结束");
                break;
            }
        }
    }

    public static void main(String[] args) {
        random();
    }
}
