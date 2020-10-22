package com.lwf.classCode;

/**
 * @author lwf
 * @title: Panda
 * @projectName ReflectLearn
 * @description: TODO
 * @date 2020/10/2214:48
 */
public class Panda {
    private String name;
    private String city;

    public Panda() {
    }

    public Panda(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Panda{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
