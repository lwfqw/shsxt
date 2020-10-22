package com.lwf.annotation;

/**
 * @author lwf
 * @title: Student
 * @projectName ReflectLearn
 * @description: TODO
 * @date 2020/10/2217:49
 */
public class Student {
    private int id;
    @MyAnnotationPlus
    private String name;
    @MyAnnotationPlus("上饶")
    private String city;

    public Student() {
    }
    public Student(int id) {

        this.id = id;
    }

    public Student(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
