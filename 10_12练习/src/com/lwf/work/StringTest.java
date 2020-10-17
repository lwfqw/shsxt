package com.lwf.work;

/**
 * @author lwf
 * @title: StringTest
 * @projectName 10_12练习
 * @description: 练习startWith endsWith
 * @date 2020/10/1210:39
 */
public class StringTest {
    public static void main(String[] args) {
        String[] names={"刘二根","王铁柱","皮斯亮","张翠花","刘狗柱"};
        System.out.println("老刘家");
        for(String s:names){
            if (s.startsWith("刘"))
                System.out.println(s);
        }
        System.out.println("刘姓，尾柱");
        for(String s:names){
            if (s.startsWith("刘")&&s.endsWith("柱"))
                System.out.println(s);
        }
    }
}
