package com.lwf.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author lwf
 * @title: Panda
 * @projectName 11_21SpringIOC
 * @description: TODO
 * @date 2020/11/2114:15
 */
@ToString
@AllArgsConstructor
public class Panda implements Serializable {
    private String name;
    private String city;
    private Integer age;

    public Panda() {
        System.out.println("构造器");
    }

    public String getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = (String) name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(Object city) {
        this.city = (String) city;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Object age) {
        this.age = Integer.valueOf(age+"");
    }
}
