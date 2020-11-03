package com.lwf.classTest.POJO;

import java.lang.reflect.Field;

/**
 * @author lwf
 * @title: Student
 * @projectName 11_02Ojdbc
 * @description: TODO
 * @date 2020/11/217:45
 */
public class Student {
    private String sno;
    private String sname;
    private Integer sage;
    private String sdept;

    public static void main(String[] args) throws NoSuchFieldException {
        Field field=Student.class.getDeclaredField("sno");
        System.out.println(field.getName());
    }
    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getSdept() {
        return sdept;
    }

    public void setSdept(String sdept) {
        this.sdept = sdept;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                ", sdept='" + sdept + '\'' +
                '}';
    }
}
