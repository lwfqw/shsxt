package com.lwf.test;
import com.lwf.Entity.Emp;
import com.lwf.Entity.Students;
import com.lwf.mappers.CnameMapper;
import com.lwf.mappers.EmpMapper;
import com.lwf.mappers.StudentsMapper;
import com.lwf.utils.SessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * @author lwf
 * @title: UsersTest
 * @projectName 11_5MybatisReview
 * @description: TODO
 * @date 2020/11/519:20
 */
public class EmpTest {
    SqlSession sqlSession=null;
    @Before
    public void before(){
        sqlSession=new SessionFactory().getSession();
    }
 @Test
    public void selectUser() {
//     StudentsMapper mapper=sqlSession.getMapper(StudentsMapper.class);
//     mapper.query().forEach(System.out::println);
//     mapper.queryDetail().forEach(System.out::println);
//     CnameMapper mapper=sqlSession.getMapper(CnameMapper.class);
//     mapper.query().forEach(System.out::println);
     EmpMapper mapper=sqlSession.getMapper(EmpMapper.class);
     mapper.queryByDept(30).forEach(System.out::println);
     System.out.println("7777");
     mapper.queryByDept(10).forEach(System.out::println);
 }
 @After
    public void after(){
        sqlSession.commit();
        sqlSession.close();
 }
}
