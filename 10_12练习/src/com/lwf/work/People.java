package com.lwf.work;

/**
 * @author lwf
 * @title: People
 * @projectName 10_12练习
 * @description: TODO
 * @date 2020/10/129:10
 */
public class People implements Cloneable{
    private String name;
    private int age;
    private Computer computer;

    public People(String name, int age, Computer computer) {
        this.name = name;
        this.age = age;
        this.computer = computer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        People object= (People) super.clone();
        object.setComputer((Computer) object.getComputer().clone());
        return object;
    }
}
