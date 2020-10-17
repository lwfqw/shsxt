package com.lwf.work;

/**
 * @author lwf
 * @title: TestClone
 * @projectName 10_12练习
 * @description: TODO
 * @date 2020/10/129:13
 */
public class TestClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Computer computer=new Computer("华为", "蓝色");
        People people=new People("罗卫飞", 18, computer);
        People people1= (People) people.clone();
        System.out.println(people==people1);
        System.out.println(people.getComputer()==people1.getComputer());
    }
}
