package com.lwf.classWork;

/**
 * @author lwf
 * @title: QQ
 * @projectName LearnExtends
 * @description: TODO
 * @date 2020/10/1011:38
 */
public class QQ {
    private String qq;
    private String pwd;

    public QQ(String qq, String pwd) {
        this.qq = qq;
        this.pwd = pwd;
    }

    public void delete(){
        System.out.println("无法删除访问记录");
    }

    @Override
    public String toString() {
        return "QQ{" +
                "qq='" + qq + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
