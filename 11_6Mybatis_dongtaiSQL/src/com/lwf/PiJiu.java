package com.lwf;

import com.lwf.Entity.Output;
import com.lwf.mappers.OutputMapper;
import com.lwf.utils.SessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lwf
 * @title: PiJiu
 * @projectName 11_6Mybatis_dongtaiSQL
 * @description: TODO
 * @date 2020/11/621:15
 */
public class PiJiu {
    public static void main(String[] args) {
//        List<Output> list=new ArrayList<>();
//        list.add(new Output(1,1995,6,7,9,8,30));
//        list.add(new Output(2,1996,9,12,13,10,44));
//        list.add(new Output(3,1997,13,14,17,13,57));
//        list.add(new Output(4,1998,15,18,19,14,66));
//        list.add(new Output(5,1999,18,20,24,19,81));
//        list.add(new Output(6,2000,22,24,29,23,98));
//        list.add(new Output(7,2001,23,26,32,24,105));
//        list.add(new Output(8,2002,25,32,37,26,120));
//        list.add(new Output(9,2003,30,38,42,30,140));
//        list.add(new Output(10,2004,29,39,50,35,153));
//        list.add(new Output(11,2005,30,39,51,37,157));
//        list.add(new Output(12,2006,29,42,55,38,164));
        SqlSession sqlSession= new SessionFactory().getSession();
        OutputMapper mapper = sqlSession.getMapper(OutputMapper.class);
        //System.out.println(mapper.insertSome(list));
        System.out.println("平均值");
        List<Output> all = mapper.all();
        int num=0;
        for(int i=0;i<all.size()-1;i++){
            num+=(all.get(i+1).getTotal()-all.get(i).getTotal());
        }
        int avg=num/all.size()-1;
        System.out.println(avg);
        System.out.println("预测未来5年");
        num=mapper.pridict();
        for(int i=0;i<5;i++){
            num+=avg;
            System.out.println(num);
        }
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入年份查询");
        int year=scanner.nextInt();
        if(year<1995){
            System.out.println("没有数据");
        }else if(year>=1995&&year<=2006){
            System.out.println(mapper.queryByYear(year));
        }else {
            System.out.println("预测:"+(mapper.queryByYear(2006).getTotal()+avg*(year-2006)));
        }
        scanner.close();
        sqlSession.commit();
        sqlSession.close();
    }
}
