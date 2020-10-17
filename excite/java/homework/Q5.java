package homework;

/**
 * Created by IntelliJ IDEA.
 * User: lwf-pc
 * Auther: 罗卫飞
 * Date: 2020/9/28
 * 判断一个日期是这年的第几天
 */
public class Q5 {
    public static int[][] cus = new int[2][10]; //二维数组存放闰年和平年的3月到12月之前的时间方便计算

    //开始赋值,平年
    static {
        cus[0][0] = 31 + 28;//一月和二月总天数
        cus[0][1] = 31 + 28 + 31;
        cus[0][2] = 31 + 28 + 31 + 30;
        cus[0][3] = 31 + 28 + 31 + 30 + 31;
        cus[0][4] = 31 + 28 + 31 + 30 + 31 + 30;
        cus[0][5] = 31 + 28 + 31 + 30 + 31 + 30 + 31;
        cus[0][6] = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31;
        cus[0][7] = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30;
        cus[0][8] = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31;
        cus[0][8] = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30;//一月到11月的天数
        //闰年比平年多一天
        for (int i = 0; i < 10; i++) {
            cus[1][i] = cus[0][i] + 1;
        }
    }

    /**
     * 判断一个日期是这年中第几天
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static int tianShu(int year, int month, int day) {
        //闰年：
        if ((year % 400 == 0) || ((year % 100 != 0) && (year % 4 == 0))) {
            //一月结果为天数
            if (month == 1) {
                return day;
            } else if (month == 2) {//二月为一月天数加日期的天
                return 31 + day;
            } else if (month > 2 && month <= 12) {//三月到12月，分别是数组cus中第一维数据加天数
                return cus[1][month - 3] + day;
            }
        } else {
            //一月结果为天数
            if (month == 1) {
                return day;
            } else if (month == 2) {//二月为一月天数加日期的天
                return 31 + day;
            } else if (month > 2 && month <= 12) {//三月到12月，分别是数组cus中第一维数据加天数
                return cus[0][month - 3] + day;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("2020-10-1");
        System.out.println(tianShu(2020, 10, 1));
        System.out.println("2020-3-1");
        System.out.println(tianShu(2020, 3, 1));
    }
}