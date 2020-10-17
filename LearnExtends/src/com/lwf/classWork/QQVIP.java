package com.lwf.classWork;

/**
 * @author lwf
 * @title: QQVIP
 * @projectName LearnExtends
 * @description: TODO
 * @date 2020/10/1011:38
 */
public class QQVIP extends QQ {
    public QQVIP(String qq, String pwd) {
        super(qq, pwd);
    }

    public void delete(){
     System.out.println("删除访问记录");
 }

    @Override
    public String toString() {
        return "QQVIP: " + super.toString();
    }

    public static void main(String[] args) {
        QQ qq=new QQ("5121324255", "1235446");
        QQVIP qqvip=new QQVIP("519155720","8888888888");
        qq.delete();
        System.out.println(qq.toString());
        qqvip.delete();
        System.out.println(qqvip.toString());
    }
}
