package com.lwf;

import java.util.Date;

/**
 * @author lwf
 * @title: BasePlusSalesEmpolyee
 * @projectName InterFaceAndExtends
 * @description: TODO
 * @date 2020/10/1110:23
 */
public class BasePlusSalesEmpolyee extends SalesEmployee{
    private double base;

    public BasePlusSalesEmpolyee(String name, Date date, double monthSell, double tiCheng, double base) {
        super(name, date, monthSell, tiCheng);
        this.base = base;
    }

    @Override
    public double getSalary(int month) {
        month+=1;
        if(getDate().getMonth()==month){
            return getMonthSell()*getTiCheng()+base+200;
        }else {
            return getMonthSell()*getTiCheng()+base;
        }
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    @Override
    public String toString() {
        return "BasePlusSalesEmpolyee{" +
                "base=" + base  + super.toString()+"}";
    }
}
