package com.lwf.POJO;

/**
 * @author lwf
 * @title: Panda
 * @projectName 11_16ServletOne
 * @description: TODO
 * @date 2020/11/1614:03
 */
public class Panda {
    private String name;
    private Integer age;

    public Panda(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Panda{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
