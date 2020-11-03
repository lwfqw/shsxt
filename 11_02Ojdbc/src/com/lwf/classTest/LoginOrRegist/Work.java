package com.lwf.classTest.LoginOrRegist;

import com.lwf.classTest.JDBCUtils;
import com.lwf.classTest.POJO.Sc;
import com.lwf.classTest.POJO.Users;
import com.lwf.classTest.ReflectJDBC.OracleJDBCUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * @author lwf
 * @title: Work
 * @projectName 11_02Ojdbc
 * @description:
 * create table users(
 * name varchar2(20) primary key,
 * password varchar2(16) not null
 * );
 * @date 2020/11/221:21
 */
public class Work {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IllegalAccessException, IOException, InstantiationException {
       //regist();
       login();
    }
    public static void regist() throws SQLException, IOException, ClassNotFoundException, IllegalAccessException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("注册");
        System.out.println("用户名 密码:");
        OracleJDBCUtils<Users> utils=new OracleJDBCUtils<>("oracle.properties");
        String[] info=scanner.nextLine().split("\\s+");
        scanner.close();
        Users users=new Users();
        users.setName(info[0]);
        users.setPassword(info[1]);
        utils.insert(users);
    }
    public static void login() throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("登录");
        System.out.println("用户名 密码:");
        OracleJDBCUtils<Users> utils=new OracleJDBCUtils<>("oracle.properties");
        String[] info=scanner.nextLine().split("\\s+");
        List<Users> list=utils.query(Users.class);
        for(Users users:list){
            if(users.getName().equals(info[0])&&users.getPassword().equals(info[1])){
                System.out.println("密码正确：");
                //操作
                System.out.println("1，个人信息：2，改名；3，改密码");
                int flag=scanner.nextInt();
                switch (flag){
                    case 1:{
                        query(info[0]);
                    }break;
                    case 2:{
                        changeName(info[0],scanner.next());
                    }break;
                    case 3:{
                        changePassword(info[0],scanner.next());
                    }break;
                    default:{
                        System.out.println("退出");
                    }
                }
            }else {
                System.out.println("密码错误");
            }
        }
        scanner.close();
    }
    private static void query(String name) throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        OracleJDBCUtils<Users> utils=new OracleJDBCUtils<>("oracle.properties");
        System.out.println("我的信息");
        for(Object users:utils.query(Users.class)){
            Users users1=(Users)users;
            System.out.println(users1);
        }
    }
    private static void changeName(String name,String new_name) throws SQLException, IOException, ClassNotFoundException {
        JDBCUtils.update("update users set name=? where name=?",new String[]{name,new_name},new Class[]{String.class,String.class});
    }
    private static void changePassword(String name,String pwd) throws SQLException, IOException, ClassNotFoundException {
        JDBCUtils.update("update users set password=? where name=?",new String[]{pwd,name},new Class[]{String.class,String.class});
    }
}
