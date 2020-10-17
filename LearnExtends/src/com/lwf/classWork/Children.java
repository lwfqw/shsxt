package com.lwf.classWork;

/**
 * @author lwf
 * @title: Children
 * @projectName LearnExtends
 * @description: TODO
 * @date 2020/10/1011:02
 */
public class Children extends Father {
    static {
        System.out.println("2静态块");
    }
    {
        System.out.println("2构造块");
    }
    public Children(){
        super();
        System.out.println("2构造方法");
    }

    public static void main(String[] args) {
        Children children=new Children();
    }
}
