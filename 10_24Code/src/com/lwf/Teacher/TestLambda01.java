package com.lwf.Teacher;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 题一:调用Collections.sort()方法,通过定值排序比较两个Employee(先按年龄比,年龄相同按姓名比),使用Lambda作为参数传递
 * 分析:
 * 	1.定制排序:指自定义比较器|定制排序
 * 	      自然排序:内部比较器|自然排序
 *  2.先比较年龄,年龄相同才比较姓名
 */
public class TestLambda01 {
	public static void main(String[] args) {
		List<Employee> list=new ArrayList<>();
		list.add(new Employee("lwf4", 19));
		list.add(new Employee("lwf1", 16));
		list.add(new Employee("lwf2", 20));
		list.add(new Employee("lwf3", 16));
		//比较年龄
		Collections.sort(list, new Compate());
		System.out.println(list);
		//先比较年龄,年龄相同才比较姓名
		Collections.sort(list);
		System.out.println(list);
	}
}
class Employee implements Comparable{
	private String name;
	private int age;

	public Employee(String name, int age) {
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
	public int compareTo(Object o) {
		Employee employee = (Employee)o;
		return this.age==employee.getAge()?name.compareTo(((Employee) o).getName()):(this.age>employee.getAge()?1:-1);
	}

	@Override
	public String toString() {
		return "Employee{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
class Compate implements Comparator<Employee>{


	@Override
	public int compare(Employee o1, Employee o2) {
		return (o1.getAge()-o2.getAge())>0?1:-1;
	}
}