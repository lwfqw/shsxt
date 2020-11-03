package com.lwf.classTest;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author lwf
 * @title: Demo2
 * @projectName 11_02Ojdbc
 * @description: TODO
 * @date 2020/11/215:51
 */
public class Demo2 {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        //语句，查询列名
        JDBCUtils.query("select * from student",new String[]{"sno","sname","ssex","sage","sdept"});
        //语句，传入sql参数，参数类型，显示列名
        JDBCUtils.query("select * from student where sno=?",new String[]{"9521105"},  new Class[]{String.class}, new String[]{"sno","sname","ssex","sage","sdept"});
        //查询grade表
        JDBCUtils.query("select * from grade",new String[]{},new Class[]{},new String[]{"low","upp","rank"});
        //修改
        JDBCUtils.startShiWu(false);//开启事务
        JDBCUtils.update("update student set sname=? where sno=?",new String[]{"罗卫飞","9521105"},new Class[]{String.class,String.class});
    }
}
