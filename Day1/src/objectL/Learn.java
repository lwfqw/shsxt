package objectL;

/**
 * @author lwf
 * @title: Learn
 * @projectName Day1
 * @description: 试验静态块等调用顺序    静态块>构造块>构造方法>普通块
 * @date 2020/10/920:05
 */
public class Learn {
    static {
        System.out.println("静态块");
    }
    {
        System.out.println("构造块");
    }
    public Learn(){
        System.out.println("构造方法");
    }
    public void test(){
        {
            System.out.println("普通块");
        }
    }

    public static void main(String[] args) {
        Learn learn=new Learn();
    }
}
