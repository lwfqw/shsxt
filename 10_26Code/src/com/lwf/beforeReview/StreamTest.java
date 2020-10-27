package com.lwf.beforeReview;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author lwf
 * @title: StreamTest
 * @projectName 10_26Code
 * @description: TODO
 * @date 2020/10/269:12
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("lwf");
        list.add("lwf");
        list.add("ppl");
        list.add("xly");
        list.add("hjx");
        System.out.println(list.stream().collect(Collectors.toSet()));
        Set<Integer> collect = list.stream().map(s -> s.hashCode()).collect(Collectors.toSet());
        System.out.println(collect);
        System.out.println(collect.stream().collect(Collectors.averagingDouble(s -> s)));
        System.out.println(list.stream().distinct().collect(Collectors.toMap(s -> s, s1 -> s1.length())));
    }
}
