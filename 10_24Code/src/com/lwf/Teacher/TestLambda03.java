package com.lwf.Teacher;
/*
 * 习题三:
 * 	1)声明一个带两个泛型的函数式接口,发型类型为<T,R> T为参数,R为返回值
 * 	2)接口中声明对应抽象方法
 *  3)在TestLambda类中声明方法,参数三个,两个long类型的参数,接口作为参数,接口实现中计算两个long型参数的和
 *  4)再计算两个long型参数的乘积
 */
public class TestLambda03 {
	public static Long caculator(long l1,long l2,Number<Long,Long> n){
		return n.function(l1,l2);
	}
	public static void main(String[] args) {
		//接口实现中计算两个long型参数的和
		System.out.println(caculator(1234l, 2345l, ((l, l1) -> l + l1)));
		//再计算两个long型参数的乘积
		System.out.println(caculator(2356l, 75642l, (l2, l3) -> l2 * l3));
	}
}
interface Number<T,R>{
	public R function(T l,T l1);
}