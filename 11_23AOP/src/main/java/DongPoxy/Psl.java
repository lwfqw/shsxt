package DongPoxy;

/**
 * @author lwf
 * @title: Psl
 * @projectName 11_23AOP
 * @description: TODO
 * @date 2020/11/2314:18
 */
public class Psl implements LaoWang,SellCar{
    @Override
    public void done() {
        System.out.println("老王(皮思亮)事发,被打了");
    }

    @Override
    public void sell() {
        System.out.println("买车给同桌，不给钱");
    }
}
