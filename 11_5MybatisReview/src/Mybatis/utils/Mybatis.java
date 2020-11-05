package Mybatis.utils;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author lwf
 * @title: MybatisCURD
 * @projectName 11_5MybatisReview
 * @description: TODO
 * @date 2020/11/515:01
 */
public interface Mybatis {
    SqlSession getSession();
    SqlSession getSession(boolean open);
    void rollBack();
    void commit();
}
