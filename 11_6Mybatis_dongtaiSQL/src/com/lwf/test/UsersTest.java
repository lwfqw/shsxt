package com.lwf.test;

import com.lwf.Entity.Users;
import com.lwf.mappers.EmpMapper;
import com.lwf.mappers.UsersMapper;
import com.lwf.utils.SessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author lwf
 * @title: UsersTest
 * @projectName 11_6Mybatis_dongtaiSQL
 * @description: TODO
 * @date 2020/11/619:13
 */
public class UsersTest {
    SqlSession sqlSession=null;
    @Before
    public void before(){
        sqlSession=new SessionFactory().getSession();
    }
    @Test
    public void selectUser() {
        UsersMapper mapper=sqlSession.getMapper(UsersMapper.class);
//        System.out.println(mapper.getPassword(1));
//        System.out.println(mapper.insert(new Users(4, "zyr", "12345")));
//        System.out.println(mapper.update(new Users(4, "zyr", "112121")));
        System.out.println(mapper.getUserById(Integer.valueOf("4")));
        //System.out.println(mapper.delete(4));
    }
    @After
    public void after(){
        sqlSession.commit();
        sqlSession.close();
    }
}
