package homework;

/**
 * Created by IntelliJ IDEA.
 * User: lwf-pc
 * Auther: 罗卫飞
 * Date: 2020/9/28
 * 求0-7所组成的奇数个数   以1，3，5，7结尾为奇数  4*A77-4*A66
 */
public class Q8 {
    /**
     * 算出A num num ,num个全排列
     * @param num
     * @return
     */
    public static int sum(int num){
        int i=1;
        for(int j=1;j<=num;j++){
            i*=j;
        }
        return i;
    }

    /**
     *
     * @return 4*A77-4*A66
     */
    public static int jiNum(){
        return 4*sum(7)-4*sum(6);
    }

    public static void main(String[] args) {
        System.out.println("奇数个数:"+jiNum());
    }
}
