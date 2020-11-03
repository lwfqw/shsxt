package com.lwf;


/**
 * @author lwf
 * @title: Test
 * @projectName 10_26Code
 * @description: TODO
 * @date 2020/10/2616:33
 */
public class Test {
    public static Test t1 = new Test();
    public static Test t2 = new Test();
    {
        System.out.println("构造块");
    }
    static {
        System.out.println("静态块");
    }
    private int anInt = 10;
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(new Test().anInt);
    }
}
