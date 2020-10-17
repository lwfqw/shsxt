package com.lwf.classWork;

/**
 * @author lwf
 * @title: Dog
 * @projectName LearnExtends
 * @description: TODO
 * @date 2020/10/1010:13
 */
public class Dog extends Animal {
    private String from;

    public Dog(String from) {
        this.from = from;
    }

    public Dog() {
    }

    public Dog(String name, int age, String color, String from) {
        super(name, age, color);
        this.from = from;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "from='" + from + '\'' +super.toString()+
                '}';
    }
}
