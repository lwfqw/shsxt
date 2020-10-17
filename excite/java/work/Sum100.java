package work;

/**
 * Created by IntelliJ IDEA.
 * User: lwf-pc
 * Auther: 罗卫飞
 * Date: 2020/9/28
 */
public class Sum100 {
    public static int sum(int end){
        int sum=0;
        for(int i=1;i<=end;i++){
            sum+=i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int sum=0;
        for(int i=1;i<=100;i++){
            sum+=sum(i);
        }
        System.out.println("结果:"+sum);
    }
}
