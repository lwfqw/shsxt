package date;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author lwf
 * @title: Test
 * @projectName Day1
 * @description: TODO
 * @date 2020/10/1119:35
 */
public class TestDate {
    public static void main(String[] args) {
        //Date date=new Date(2010,11,21);
        Date date=new Date();
        System.out.println(date.toString());

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(date));

        System.out.println(Year.now());
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDate.now());
        System.out.println((LocalDate.now()).getClass());

        LocalDate today = LocalDate.now(); LocalDate birthDate = LocalDate.of(1999, 3, 15);
        //时期间隔 年月日
        Period p = Period.between(birthDate, today);
        System.out.printf(p.getYears()+"年"+p.getMonths()+"d"+p.getDays()+"日 ");
        LocalDate startDate = LocalDate.of(1993, 8, 19);
        LocalDate endDate = LocalDate.of(1994, Month.JANUARY,16); //期量单位 间隔
        long between = ChronoUnit.YEARS.between(startDate, endDate);
        System.out.println("两年之间的差 : " + between); //0 不是1不满一年不计算 在内
        between =ChronoUnit.MONTHS.between(startDate, endDate);
        System.out.println("两月之间的差 : " + between); //4 不是5不满一月不计算 在内//瞬间
        Instant inst1 = Instant.now();
        Instant inst2 = inst1.minus(Duration.ofSeconds(10));
        System.out.println("毫秒相隔 : " + Duration.between(inst1, inst2).toMillis()); System.out.println("秒相隔 : " + Duration.between(inst1, inst2).getSeconds());
    }
}
