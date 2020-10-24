package com.lwf.Teacher;


/*
 * 习题二:
 * 	1)声明函数式接口,接口中声明抽象方法,public String getValue(String str)
 * 	2)声明类 TestLambda,类中编写方法使用接口作为参数,讲一个字符串转成大写,并作为方法的返回值
 *  3)再将一个字符串的第2个和第4个索引位置进行截取子串
 */
public class TestLambda02 {
	public static String format(String string, Formate<String> f){
		return f.getValue(string);
	}
	public static void main(String[] args) {
		//第一个字符大写
		System.out.println(format("lwf", str -> str.substring(0, 1).toUpperCase() + str.substring(1)));
		//再将一个字符串的第2个和第4个索引位置进行截取子串
		System.out.println(format("qwertuioiuy", str -> str.substring(2, 5)));
	}
}
interface Formate<T>{
	public T getValue(T str);
}
