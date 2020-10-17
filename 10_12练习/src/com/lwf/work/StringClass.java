package com.lwf.work;

/**
 * @author lwf
 * @title: StringClass
 * @projectName 10_12练习
 * @description: TODO
 * @date 2020/10/1211:28
 */
public class StringClass {
    public static void main(String[] args) {
        ZhangHao zhangHao=new ZhangHao();
        zhangHao.setName("ag,s");
        zhangHao.setPwd("123456ag,s7888976grtukgggy");

        String filename="shaDiao";
        System.out.println("get"+(filename.charAt(0)+"").toUpperCase()+filename.substring(1));
        System.out.println("set"+(filename.charAt(0)+"").toUpperCase()+filename.substring(1));
    }
}
class ZhangHao{
    private String name;
    private String pwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.contains(",")){
            System.out.println("含有敏感字,");
            return;
        }
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        if((pwd.length()<=15||pwd.length()>=30)||pwd.equals(pwd.toLowerCase())||pwd.equals(pwd.toUpperCase())){
            System.out.println("密码不合法");
            return;
        }
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "ZhangHao{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}