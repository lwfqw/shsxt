package com.lwf.ListTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @author lwf
 * @title: StudentTest
 * @projectName 10_13Test
 * @description: TODO
 * @date 2020/10/1311:56
 */
public class StudentTest <T extends Student>{
    private List<T> list;
    public StudentTest(List list){
        this.list=list;
    }
    public void add(T t){
        list.add(t);
    }
    public void add(int index,T t){
        list.add(index,t);
    }
    public void remove(T t){
        list.remove(t);
    }
    public void remove(int i){
        list.remove(i);
    }
    public T find(String name){
        Iterator iterator=list.listIterator();
        while (iterator.hasNext()){
            Student student= (Student) iterator.next();
            if(student.getName().equals(name))
                return (T) student;
        }
        return null;
    }
    @Override
    public String toString() {
        return String.valueOf(list);
    }

    public static void main(String[] args) {
      StudentTest studentTest=new StudentTest(new ArrayList());
      studentTest.add(new Student("lwf", 16));
      studentTest.add(0, new Student("www", 159999));
      System.out.println(studentTest.find("lwf"));
      studentTest.remove(0);
      Student student=new Student("xly", 21);
      studentTest.add(student);
      studentTest.remove(student);
      System.out.println(studentTest);
    }
}
class Student{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return student.getName()==((Student) o).getName();//名字相同就可以
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}