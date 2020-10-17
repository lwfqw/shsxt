package com.lwf.classWork;

/**
 * @author lwf
 * @title: Bird
 * @projectName LearnExtends
 * @description: TODO
 * @date 2020/10/1016:10
 */
public class Bird extends Animal implements Fly {
    public Bird() {
    }

    public Bird(String name, int age, String color) {
        super(name, age, color);
    }

    @Override
    public void fly() {
        System.out.println("鸟飞");
    }

    public static void main(String[] args) {
        Fly bird=new Bird("老鸟",2,"红色");
        bird.fly();
        System.out.println(bird.toString());
        Fly flyMacine=new FlyMacine();
        flyMacine.fly();
    }
}
