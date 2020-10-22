package com.lwf.homeWork;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

/**
 * @author lwf
 * @title: DayOfYear
 * @projectName ReflectLearn
 * @description: 输入时间计算一年第几天
 * @date 2020/10/2220:09
 */
public class DayOfYear {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入年 月 日:");
        String[] string = scanner.nextLine().split("\\s+");
        LocalDate localDate=LocalDate.of(Integer.valueOf(string[0]),Integer.valueOf(string[1]) ,Integer.valueOf(string[2]) );
        System.out.println(getDayOfYear(localDate));
    }
    public static int getDayOfYear(LocalDate date){
        LocalDate date1=date.withMonth(1).withDayOfMonth(1);
        return (int) ChronoUnit.DAYS.between(date1, date)+1;
    }
}
