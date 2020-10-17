package com.shsxt.demo002;

import java.util.Objects;

/**
 * 程序员
 * 职位名称
 * 年龄
 * 性别
 * 电脑
 *
 * // 。。。
 */
public class Coder {
    private String job;
    private int age;
    private boolean gender;
    private Computer computer;

    public Coder() {
    }

    @Override
    public String toString() {
        return "Coder{" +
                "job='" + job + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", computer=" + computer +
                '}';
    }

    public Coder(String job, int age, boolean gender, Computer computer) {
        this.job = job;
        this.age = age;
        this.gender = gender;
        this.computer = computer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(job, age, gender, computer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coder coder = (Coder) o;
        return age == coder.age &&
                gender == coder.gender &&
                job.equals(coder.job) &&
                computer.equals(coder.computer);
    }

    public static void main(String[] args) {
        Coder coder=new Coder();
        Coder coder1=new Coder();
       System.out.println(coder.equals(coder1));
        System.out.println(coder);
    }
}
