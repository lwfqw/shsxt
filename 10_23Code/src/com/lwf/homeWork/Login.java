package com.lwf.homeWork;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author lwf
 * @title: Login
 * @projectName 10_23Code
 * @description:  正则表达式匹配用户名密码格式
 * @date 2020/10/2319:57
 */
public class Login {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        boolean flag=false;
        String user = null,pwd = null;
        while (!flag){
            System.out.println("注册");
            System.out.println("用户名(字母开头5-9位)");
            user = scanner.next();
            System.out.println("密码（大写字母开头12-14位）");
            pwd=scanner.next();
            if(!Check.loginCheck(user, Type.user)){
                System.out.println("错误的名字，请重新注册");
                continue;
            }else if(!Check.loginCheck(pwd, Type.pwd)){
                System.out.println("密码格式错误，请重新注册");
                continue;
            }else{
                System.out.println("注册成功:"+user+"   ,password:"+pwd);
                break;
            }

        }
        while (!flag){
            System.out.println("登录");
            System.out.println("用户名(字母开头5-9位)");
            String user1 = scanner.next();
            System.out.println("密码（大写字母开头12-14位）");
            String pwd1=scanner.next();
            if(!Check.loginCheck(user1, Type.user)){
                System.out.println("错误的名字，请重新登录");
                continue;
            }else if(!Check.loginCheck(pwd1, Type.pwd)){
                System.out.println("密码格式错误，请重新登录");
                continue;
            }else{
                if(pwd.equals(pwd1)&&user.equals(user1)){
                    System.out.println("密码正确");
                    break;
                }
                System.out.println("密码错误");
                continue;
            }

        }
        scanner.close();
    }
}
class Check{
    public static boolean loginCheck(String str,Type type){
        Pattern user=Pattern.compile("[a-zA-Z]\\w{4,8}");
        Pattern pwd = Pattern.compile("[A-Z](\\w|\\W){11,14}");
        if(type.equals(Type.pwd)){
            return pwd.matcher(str).matches();
        }else {
            return user.matcher(str).matches();
        }
    }
}
enum Type{
    user,pwd;
}