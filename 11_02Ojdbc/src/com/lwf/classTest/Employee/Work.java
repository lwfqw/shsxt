package com.lwf.classTest.Employee;

import com.lwf.classTest.JDBCUtils;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author lwf
 * @title: Woprk
 * @projectName 11_02Ojdbc
 * @description: TODO
 * @date 2020/11/222:01
 */
public class Work {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        infomation();
        detail();
    }

    /**
     * 查员工表
     * @throws SQLException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void  infomation() throws SQLException, IOException, ClassNotFoundException {
        JDBCUtils.query("select * from emps", new String[]{}, new Class[]{}, new String[]{"eno","ename","mno","zno"});
    }
    /**
     * 查员工信息，包括民族名，职称名
     */
    public static void  detail() throws SQLException, IOException, ClassNotFoundException {
        JDBCUtils.query("select eno,ename,(select mname from minzu where mno=emps.mno) mname,(select zname from zhichen where zno=emps.zno) zname from emps", new String[]{}, new Class[]{}, new String[]{"eno","ename","mname","zname"});
    }
}
