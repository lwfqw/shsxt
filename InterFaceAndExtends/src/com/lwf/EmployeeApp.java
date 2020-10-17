package com.lwf;

import java.util.Date;

/**
 * @author lwf
 * @title: EmployeeApp
 * @projectName InterFaceAndExtends
 * @description: TODO
 * @date 2020/10/1110:32
 */
public class EmployeeApp {
    public static void main(String[] args) {
        Employee employee=new HourEmployee("皮斯亮", new Date(), 12, 32);
        System.out.println(employee.getSalary(9));
        System.out.println(employee.toString());
        Employee employee1=new BasePlusSalesEmpolyee("aaa", new Date(), 22, 0.7, 2000);
        System.out.println(employee1.getSalary(9));
        System.out.println(employee1.toString());
    }
}
