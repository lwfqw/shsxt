package com.lwf.mappers.impl;

import com.lwf.mappers.UserMapper;
import com.lwf.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author lwf
 * @title: UserMapperImpl
 * @projectName 11_20fremark
 * @description: TODO
 * @date 2020/11/2020:56
 */
public class UserMapperImpl {
    static SqlSession sqlSession=null;
    static {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
            sqlSession= new SqlSessionFactoryBuilder().build(resourceAsStream).openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<User> all(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.all();
    }
    public static void close(){
        sqlSession.close();
    }

    public static void main(String[] args) {
        all().forEach(System.out::println);
        close();
    }
}
