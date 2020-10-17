package com.lwf.classWork;

/**
 * @author lwf
 * @title: ErHa
 * @projectName LearnExtends
 * @description: TODO
 * @date 2020/10/1010:16
 */
public class ErHa extends Dog {
    public void FanEr(){
        System.out.println(super.getName()+"犯二");
    }

    public ErHa(String from) {
        super(from);
    }

    public ErHa() {
    }

    @Override
    public String getFrom() {
        return super.getFrom();
    }

    @Override
    public void setFrom(String from) {
        super.setFrom(from);
    }

    @Override
    public void huxi() {
        super.huxi();
    }

    @Override
    public void eat() {
        super.eat();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public void setColor(String color) {
        super.setColor(color);
    }

    public ErHa(String name, int age, String color, String from) {
        super(name, age, color, from);
    }

    @Override
    public String toString() {
        return "ErHa{} " + super.toString();
    }
}
