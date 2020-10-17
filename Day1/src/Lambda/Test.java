package Lambda;

/**
 * @author lwf
 * @title: Test
 * @projectName Day1
 * @description: TODO
 * @date 2020/10/920:18
 */
public class Test {
    public static void main(String[] args) {
        //匿名类
        Cup cup=new Cup() {
            @Override
            public void zhuangShui(int in) {
                System.out.println("装水"+in+"升");
            }
        };
        cup.zhuangShui(10);
    }
}
interface Cup {
    void zhuangShui(int in);
}