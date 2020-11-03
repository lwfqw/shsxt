package com.lwf.classTest;

import java.io.IOException;
import java.sql.*;

/**
 * @author lwf
 * @title: OjdbcDemo1
 * @projectName 11_02Ojdbc
 * @description: TODO
 * @date 2020/11/211:50
 */
public class OjdbcDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("oracle.jdbc.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SCOTT", "TIGER");
        Statement statement=connection.createStatement();
        ResultSet rs=statement.executeQuery("select * from student");
        while (rs.next()){
            System.out.println(rs.getString(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
            System.out.println(rs.getInt(4));
            System.out.println(rs.getString(5));
        }
        JDBCUtils.close(connection,statement,rs);
    }
}
