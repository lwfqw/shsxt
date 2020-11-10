package com.lwf;

import com.lwf.Entity.Users;
import com.lwf.mappers.UsersMapper;
import com.lwf.utils.SessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.Scanner;

/**
 * @author lwf
 * @title: StudentManage
 * @projectName 11_6Mybatis_dongtaiSQL
 * @description: TODO
 * @date 2020/11/619:34
 */
public class StudentManage implements Runnable {
    public static void main(String[] args) {
        new Thread(new StudentManage()).start();
    }
    private SqlSession session=null;
    Scanner scanner=new Scanner(System.in);
    private Users current=null;
    {
     session=new SessionFactory().getSession(true);
    }
    @Override
    public void run() {
        synchronized (this) {
            while (true) {
                System.out.println("请登录:（1 账号 密码）注册（0，姓名，密码）；退出(除1,0数字)");
                String[] info=scanner.nextLine().split("\\s+");
                if(info.length==3){
                    if(Integer.valueOf(info[0])==0){
                        regist(info);
                    }else if(Integer.valueOf(info[0])==1){
                        login(info);
                    }else {
                        System.out.println("错误");
                        continue;
                    }
                }else {
                    close();
                    System.out.println("输入格式不正确");
                }
            }
        }
    }
    private void close(){
        scanner.close();
        session.close();
        Thread.currentThread().stop();
    }
    private void login(String[] args){
        UsersMapper mapper = session.getMapper(UsersMapper.class);
        if(mapper.getPassword(Integer.valueOf(args[1])).equals(args[2])){
            System.out.println("登录成功");
            current=mapper.getUserById(Integer.valueOf(args[1]));
            System.out.println("输入业务:1,变更；2，注销；3，个人信息;其他,退出");
            System.out.println("输入变更信息，用空格隔开，一位修改姓名，两位修改密码");
            while (true){
                int done=scanner.nextInt();
                if(done<1||done>3){
                    System.out.println("退出："+current.getName());
                    return;
                }
                switch (done){
                    case 1:{
                        String[] change=scanner.nextLine().trim().split("\\s+");
                        if(change.length==1){
                            int succ=mapper.update(new Users(current.getId(), change[0],current.getPassword()));
                            System.out.println("修改姓名："+(succ==1?true:false));
                            current=mapper.getUserById(current.getId());
                        }else if(change.length==2){
                            int succ=mapper.update(new Users(current.getId(), change[0],change[1]));
                            System.out.println("修改姓名,密码："+(succ==1?true:false));
                            current=mapper.getUserById(current.getId());
                        }
                    };break;
                    case 2:{
                        System.out.println("注销用户:"+mapper.delete(current.getId()));
                        return;
                    }
                    case  3:{
                        System.out.println(current.getId()+":"+current.getName());
                    }
                }
            }
        }else {
            System.out.println("验证失败");
        }
    }
    private void regist(String[] args){
        System.out.println("注册：");
        if(args.length==3){
            UsersMapper mapper = session.getMapper(UsersMapper.class);
            int i=mapper.insert(new Users(mapper.maxId()+1, args[1],args[2]));
            System.out.println("注册"+(i>0?true:false));
            if(i>0){
                System.out.println("账号："+mapper.maxId());
            }
        }else {
            System.out.println("输入错误");
        }
    }
}
