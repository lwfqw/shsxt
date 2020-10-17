package work;

/**
 * Created by IntelliJ IDEA.
 * User: lwf-pc
 * Auther: 罗卫飞
 * Date: 2020/9/28
 * 分别用for和while计算1到100奇数偶数和
 */
public class QiAndOu {
    /**
     * for求1到100奇数偶数和
     */
    public static void sumFor(){
        int ji=0;
        int ou=0;
        for(int i=1;i<=100;i++){
            if(i%2==0)
                ou+=i;
            else
                ji+=i;
        }
        System.out.println("奇数和:"+ji+",偶数和:"+ou);
    }
    public static void sumWhile(){
        int ji=0;
        int ou=0;
        int i=0;
        while (i++<100){
            if(i%2==0)
                ou+=i;
            else
                ji+=i;
        }
        System.out.println("奇数和:"+ji+",偶数和:"+ou);
    }

    public static void main(String[] args) {
        sumFor();
        sumWhile();
    }
}
