package com.lwf;

import java.util.Date;

/**
 * @author lwf
 * @title: Employee
 * @projectName InterFaceAndExtends
 * @description: TODO
 * @date 2020/10/119:43
 */
public class Employee {
    private String name;
    private Date date;

    public Employee(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public Employee() {
    }

    public double getSalary(int month){
        month+=1;
        if(date.getMonth()==month){
            return 10000+200;
        }else {
            return 10000;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String toString(){
        return "员工:"+name+",生日:"+date;
    }
}
