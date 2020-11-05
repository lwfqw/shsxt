package Mybatis.test;

import Mybatis.Emtity.Users;
import Mybatis.Mapper.UsersMapper;
import Mybatis.utils.Mybatis;
import Mybatis.utils.SessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author lwf
 * @title: UsersTest
 * @projectName 11_5MybatisReview
 * @description: TODO
 * @date 2020/11/519:20
 */
public class UsersTest {
    SqlSession sqlSession=null;
    @Before
    public void before(){
        sqlSession=new SessionFactory().getSession();
    }
 @Test
    public void selectUser(){
     UsersMapper mapper=sqlSession.getMapper(UsersMapper.class);
     mapper.all().forEach(System.out::println);
     mapper.update(new Users(2, null, "1234"));
     mapper.insert(new Users(4, "ppl", "1234"));
     System.out.println(mapper.getById(4));
     mapper.delete(4);
 }
 @After
    public void after(){
        sqlSession.commit();
        sqlSession.close();
 }
}
