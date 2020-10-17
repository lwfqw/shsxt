package com.lwf.classWork;

/**
 * @author lwf
 * @title: Father
 * @projectName LearnExtends
 * @description: TODO
 * @date 2020/10/1011:01
 */
public class Father {
    static {
        System.out.println("1静态块");
    }
    {
        System.out.println("1构造块");
    }
    public Father(){
        System.out.println("1构造方法");
    }
}
