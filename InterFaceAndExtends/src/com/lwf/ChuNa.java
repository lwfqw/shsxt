package com.lwf;

import java.util.Date;

/**
 * @author lwf
 * @title: ChuNa
 * @projectName InterFaceAndExtends
 * @description: TODO
 * @date 2020/10/1111:13
 */
public class ChuNa extends Employee{
    public ChuNa(String name, Date date) {
        super(name, date);
    }

    public ChuNa() {
        super();
    }

    public double provideSala(Employee employee, int month){
        System.out.println(employee.toString());
        System.out.println(employee.getSalary(month));
        return employee.getSalary(month);
    }

    @Override
    public double getSalary(int month) {
        month++;
        return month==getDate().getMonth()?10200:10000;
    }
}
