package work;

/**
 * Created by IntelliJ IDEA.
 * User: lwf-pc
 * Auther: 罗卫飞
 * Date: 2020/9/28
 * 计算1000以内被5整除的数每行输出3个
 */
public class BeiZhenChu {
    public static void chu(){
        int j=0;
        int[] s=new int[3];
        for(int i=1;i<=1000;i++){
            if(i%5==0){
                s[j]=i;
                j++;
                if(j==3){
                    System.out.println(s[0]+","+s[1]+","+s[2]);
                    j=0;
                }
            }
        }
        System.out.println(s[0]+","+s[1]+","+s[2]);
    }

    public static void main(String[] args) {
        BeiZhenChu.chu();
    }
}
