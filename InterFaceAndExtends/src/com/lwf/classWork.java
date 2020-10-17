package com.lwf;

/**
 * @author lwf
 * @title: classWork
 * @projectName InterFaceAndExtends
 * @description: TODO
 * @date 2020/10/119:27
 */
public class classWork {
    public static void main(String[] args) {
        TaiDeng taiDeng=new TaiDeng(new GreenBuble());
        taiDeng.open();
    }
}
class Buble{
    public void open(){
        System.out.println("发光");
    }
}
class RedBuble extends Buble{
    @Override
    public void open() {
        System.out.println("发红光");
    }
}
class GreenBuble extends Buble{
    @Override
    public void open() {
        System.out.println("发绿光");
    }
}
class TaiDeng{
    private Buble buble;

    public TaiDeng(Buble buble) {
        this.buble = buble;
    }

    public void open(){
        System.out.println("打开台灯");
        buble.open();
    }
}