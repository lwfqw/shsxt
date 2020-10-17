package com.lwf.work;

import javax.swing.text.DateFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author lwf
 * @title: DataTest
 * @projectName 10_12练习
 * @description: TODO
 * @date 2020/10/1214:29
 */
public class DataTest {
    public static void main(String[] args) throws ParseException {
//        Date date=new Date();
//        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        System.out.println(simpleDateFormat.format(date));
//        Date date1=new Date(2020,12,21,12,23,56);
//        System.out.println(date1.after(date));
//        System.out.println(date1.before(date));
//        Date date2=simpleDateFormat.parse("1990-12-12 12:21:19");
//        System.out.println(date2);
//        System.out.println(simpleDateFormat.format(date2));
//        LocalDate localDate=LocalDate.now();
//        LocalDate localDate1=LocalDate.of(2020, 10, 13);
//        Period period=Period.between(localDate,localDate1);
//        if(period.getDays()<1)
//            System.out.println("一日达");
//        else
//            System.out.println("超时");
        LocalDateTime localDateTime=LocalDateTime.now();
        LocalDateTime localDateTime1= LocalDateTime.of(localDateTime.getYear(), localDateTime.getMonth(), localDateTime.getDayOfMonth(), 11, 0);
        long chronoUnit= ChronoUnit.HOURS.between(localDateTime,localDateTime1);
        System.out.println(chronoUnit);
        if(chronoUnit>0)
            System.out.println("当日");
        else
            System.out.println("明日"+localDateTime1.withDayOfYear(localDateTime1.getDayOfMonth()+1));
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
        System.out.println(localDateTime.format(dateTimeFormatter));
    }
}
