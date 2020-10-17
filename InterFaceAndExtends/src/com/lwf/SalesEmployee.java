package com.lwf;

import java.util.Date;

/**
 * @author lwf
 * @title: SalesEmployee
 * @projectName InterFaceAndExtends
 * @description: TODO
 * @date 2020/10/119:55
 */
public class SalesEmployee extends Employee {
    private double monthSell;
    private double tiCheng;
    public double getSalary(int month) {
        month+=1;
        if(getDate().getMonth()==month){
            return monthSell*tiCheng+200;
        }else {
            return monthSell*tiCheng;
        }
    }
    public SalesEmployee(String name, Date date, double monthSell, double tiCheng) {
        super(name, date);
        this.monthSell = monthSell;
        this.tiCheng = tiCheng;
    }

    public double getMonthSell() {
        return monthSell;
    }

    public void setMonthSell(double monthSell) {
        this.monthSell = monthSell;
    }

    public double getTiCheng() {
        return tiCheng;
    }

    public void setTiCheng(double tiCheng) {
        this.tiCheng = tiCheng;
    }

    @Override
    public String toString() {
        return "SalesEmployee{" +
                "monthSell=" + monthSell +
                ", tiCheng=" + tiCheng  + super.toString()+
                "} ";
    }
}
