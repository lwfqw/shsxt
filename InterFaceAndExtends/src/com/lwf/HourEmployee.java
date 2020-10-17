package com.lwf;

import java.util.Date;

/**
 * @author lwf
 * @title: HourEmployee
 * @projectName InterFaceAndExtends
 * @description: TODO
 * @date 2020/10/119:51
 */
public class HourEmployee extends Employee {
    private double hourGet;
    private double hourNum;

    public HourEmployee(String name, Date date, double hourGet, double hourNum) {
        super(name, date);
        this.hourGet = hourGet;
        this.hourNum = hourNum;
    }

    public double getHourGet() {
        return hourGet;
    }

    public void setHourGet(double hourGet) {
        this.hourGet = hourGet;
    }

    public double getHourNum() {
        return hourNum;
    }

    public void setHourNum(double hourNum) {
        this.hourNum = hourNum;
    }

    @Override
    public double getSalary(int month) {
        month+=1;
        if(getDate().getMonth()==month){
            return hourNum>=160?hourGet*160+(hourNum-160)*1.5*hourGet:hourGet*hourNum+200;
        }else {
            return hourNum>=160?hourGet*160+(hourNum-160)*1.5*hourGet:hourGet*hourNum;
        }
    }

    @Override
    public String toString() {
        return "HourEmployee{" +
                "hourGet=" + hourGet +
                ", hourNum=" + hourNum  + super.toString()+
                "} ";
    }
}
