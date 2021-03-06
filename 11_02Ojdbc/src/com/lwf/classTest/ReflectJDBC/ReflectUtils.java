package com.lwf.classTest.ReflectJDBC;

import java.sql.SQLException;
import java.util.List;

/**
 * @author lwf
 * @title: ReflectUtils
 * @projectName 11_02Ojdbc
 * @description: 反射数据库curd，必须属性名与表列名一致
 * @date 2020/11/218:37
 */
public interface ReflectUtils <T>{
    /**
     * 根据class反射获取对应表的属性封装到对应javabean
     * @param c  类
     * @return
     */
    List<T> query(Class c) throws SQLException, IllegalAccessException, InstantiationException;

    /**
     * 根据class反射删除对应j表数据
     * @param t
     * @return
     */
    boolean delete(T t) throws SQLException, IllegalAccessException;

    /**
     * 更新对应主键
     * @param t
     * @return
     */
    boolean update(T t,String key) throws IllegalAccessException, NoSuchFieldException, SQLException;

    /**
     * 插入t
     * @param t
     * @return
     */
    boolean insert(T t) throws IllegalAccessException, SQLException;
}
