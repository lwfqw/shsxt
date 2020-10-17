package com.lwf.classWork;

/**
 * @author lwf
 * @title: Inter
 * @projectName LearnExtends
 * @description: TODO
 * @date 2020/10/1015:35
 */
public interface Inter {
    default void say(){
        System.out.println("hello");
    }
}
