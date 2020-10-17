package com.lwf.classWork;

/**
 * @author lwf
 * @title: Animal
 * @projectName LearnExtends
 * @description: TODO
 * @date 2020/10/1010:10
 */
public class Animal {
    private String name;
    private int age;
    private String color;

    public Animal() {
    }

    public Animal(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public void huxi(){
        System.out.println(name+"呼吸");
    }
    public void eat(){
        System.out.println(name+"吃饭");
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Animal animal=(Animal)obj;
        return this.age==animal.age&&this.color.equals(animal.color)&&this.name.equals(animal.name);
    }

    public static void main(String[] args) {
        Animal animal=new Animal("二哈",3,"黑色");
        Animal animal1=new Animal("二哈",3,"黑色");
        System.out.println(animal.equals(animal1));
        System.out.println(animal);
        System.out.println(animal1);
    }
}
