package com.lwf.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @author lwf
 * @title: SessionFactory
 * @projectName 11_5MybatisReview
 * @description: TODO
 * @date 2020/11/519:16
 */
public class SessionFactory implements Mybatis {
    private SqlSession sqlSession=null;
    {
        try {
            sqlSession=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml")).openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public SqlSession getSession() {
        return sqlSession;
    }

    @Override
    public SqlSession getSession(boolean open) {
        try {
            this.sqlSession=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml")).openSession(open);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }

    @Override
    public void rollBack() {
        sqlSession.rollback();
    }

    @Override
    public void commit() {
        sqlSession.commit();
    }
}
