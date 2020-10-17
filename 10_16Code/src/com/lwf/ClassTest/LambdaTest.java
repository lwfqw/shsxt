package com.lwf.ClassTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author lwf
 * @title: LambdaTest
 * @projectName 10_16Code
 * @description: TODO
 * @date 2020/10/1614:25
 */
public class LambdaTest {
    public static void main(String[] args) {
//        System.out.println(integerList(10, () -> {
//            Random random = new Random();
//            int res = random.nextInt(51) * 2;
//            return res;
//        }));
//
//        System.out.println(integerList(5, () -> {
//            Random random = new Random();
//            int res = random.nextInt(50)+1;
//            for (int i = 2; i <= Math.sqrt(res); i++) {
//                if ((res % i) != 0) {
//                    continue;
//                } else {
//                    res = random.nextInt(50);
//                    i=1;
//                }
//            }
//            return res;
//        }));
//        System.out.println(test("lwf", s -> "set"+s.substring(0, 1).toUpperCase() + s.substring(1)));
//        System.out.println(test("lwf", s ->"get"+s.substring(0, 1).toUpperCase() + s.substring(1)));

          List<String> list=new ArrayList<>();
          list.add("asdf");
          list.add("asd");
          list.add("as");
          list.add("af");
          list.add("我**");
        System.out.println(test(list, s -> s.length() > 3));
        System.out.println(test(list, s -> s.contains("我")));
    }
    public static List<String> test(List<String> list, Predicate<String> p){
        List list1 = new ArrayList();
        for(String s:list){
            if(p.test(s))
                list1.add(s);
        }
        return list1;
    }
    public static String test(String string, Function<String,String> function){
        return function.apply(string);
    }
    public static List<Integer> integerList(int len, Supplier<Integer> supplier){
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<len;i++){
            list.add(supplier.get());
        }
        return list;
    }
}
