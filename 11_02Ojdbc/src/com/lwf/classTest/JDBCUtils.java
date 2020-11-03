package com.lwf.classTest;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author lwf
 * @title: JDBCUtils
 * @projectName 11_02Ojdbc
 * @description: 数据库工具类
 * @date 2020/11/214:38
 */
public class JDBCUtils {
    private static Properties properties=new Properties();
    private static boolean commit=true;
    static {
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param sql  查询语句
     * @param rowName  显示列名
     * @throws SQLException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void query(String sql,String[] rowName) throws SQLException, IOException, ClassNotFoundException {
        Connection oracleConnection = ConnectionFactory.getOracleConnection(properties.getProperty("dataSources"));

        Statement statement=oracleConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            for(String s:rowName)
              System.out.print(resultSet.getObject(s)+"    ");
            System.out.println("");
        }
        close(oracleConnection, statement, resultSet);
    }

    /**
     * 预处理查询
     * @param sql  查询语句
     * @param param  传入sql参数
     * @param classes  参数类型
     * @param rowName   显示列名
     * @throws SQLException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void query(String sql,String[] param,Class[] classes,String[] rowName) throws SQLException, IOException, ClassNotFoundException {
        Connection oracleConnection = ConnectionFactory.getOracleConnection(properties.getProperty("dataSources"));

        PreparedStatement statement=oracleConnection.prepareStatement(sql);
        for(int i=0;i<param.length;i++){
            if(classes[i]==int.class){
                statement.setInt(i+1, Integer.valueOf(param[i]));
            }
            else if(classes[i]==String.class){
                statement.setString(i+1, param[i]);
            }
            else if(classes[i]==boolean.class){
                statement.setBoolean(i+1, Boolean.parseBoolean(param[i]));
            }
            else {
                System.out.println("类型错误，支持int，string，boolen");
            }
        }
        ResultSet rs=statement.executeQuery();
        while (rs.next()){
            for(String s:rowName)
                System.out.print(rs.getObject(s)+"    ");
            System.out.println("");
        }
        close(oracleConnection, statement, rs);
    }
    public static boolean update(String sql,String[] param,Class[] classes) throws SQLException, IOException, ClassNotFoundException {
        Connection oracleConnection = ConnectionFactory.getOracleConnection(properties.getProperty("dataSources"));
        //开启事务
        oracleConnection.setAutoCommit(commit);
        PreparedStatement statement=oracleConnection.prepareStatement(sql);
        for(int i=0;i<param.length;i++){
            if(classes[i]==int.class){
                statement.setInt(i+1, Integer.valueOf(param[i]));
            }
            else if(classes[i]==String.class){
                statement.setString(i+1, param[i]);
            }
            else if(classes[i]==boolean.class){
                statement.setBoolean(i+1, Boolean.parseBoolean(param[i]));
            }
            else {
                System.out.println("类型错误，支持int，string，boolen");
                return false;
            }
        }
        int rows=statement.executeUpdate();
        if(!commit){
            if(rows>0){
                oracleConnection.commit();
                System.out.println("事务完成，状态：成功；修改"+rows+"行");
            }else {
                oracleConnection.rollback();
                System.out.println("事务完成，状态：失败；修改"+rows+"行");
            }
        }
        close(oracleConnection, statement, null);
        return rows>0?true:false;
    }

    /**
     * 关闭
     * @param connection
     * @param statement
     * @param resultSet
     * @throws SQLException
     */
    public static void close(Connection connection,Statement statement,ResultSet resultSet) throws SQLException {
        if(resultSet!=null)
            resultSet.close();
        if(statement!=null)
            statement.close();
        ConnectionFactory.close(connection);
    }

    public static void startShiWu(boolean flag){
        commit=false;
    }
}
