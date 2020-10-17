package com.lwf.work;

/**
 * @author lwf
 * @title: Computer
 * @projectName 10_12练习
 * @description: TODO
 * @date 2020/10/129:08
 */
public class Computer implements Cloneable{
    private String name;
    private String color;

    public Computer(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
