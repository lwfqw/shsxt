package com.lwf.homeWork;

import java.util.Arrays;

/**
 * @author lwf
 * @title: StreamWork
 * @projectName 10_24Code
 * @description: TODO
 * @date 2020/10/2515:35
 */
public class StreamWork {
    public static void main(String[] args) {
        printAbs(new int[]{2,-5,6,-2,0,-6});
        printPow(new int[]{2,-5,6,-2,0,-6});
    }
    //打印绝对值
    public static void printAbs(int[] num){
        Arrays.stream(num).map(n->Math.abs(n)).forEach(System.out::println);
    }
    //打印平方
    public static void printPow(int[] num){
        Arrays.stream(num).map(n->n*n).forEach(System.out::println);
    }
}
