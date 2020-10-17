package com.lwf;

import java.util.Date;

/**
 * @author lwf
 * @title: SalariedEmployee
 * @projectName InterFaceAndExtends
 * @description: TODO
 * @date 2020/10/119:47
 */
public class SalariedEmployee extends Employee {
    public SalariedEmployee(String name, Date date, double yueXin) {
        super(name, date);
        this.yueXin = yueXin;
    }

    private double yueXin;

    @Override
    public double getSalary(int month) {
        month+=1;
        if(getDate().getMonth()==month){
            return yueXin+200;
        }else {
            return yueXin;
        }
    }

    public double getYueXin() {
        return yueXin;
    }

    public void setYueXin(double yueXin) {
        this.yueXin = yueXin;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                "yueXin=" + yueXin + super.toString()+
                "} ";
    }
}
