package com.lwf.classTest.POJO;

/**
 * @author lwf
 * @title: Grade
 * @projectName 11_02Ojdbc
 * @description: TODO
 * @date 2020/11/217:47
 */
public class Sc {
    private String sno;
    private String cno;
    private Integer grade;
    private String xklb;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getXklb() {
        return xklb;
    }

    public void setXklb(String xklb) {
        this.xklb = xklb;
    }

    @Override
    public String toString() {
        return "Sc{" +
                "sno='" + sno + '\'' +
                ", cno='" + cno + '\'' +
                ", grade=" + grade +
                ", xklb='" + xklb + '\'' +
                '}';
    }
}
