package com.lwf.classTest.POJO;

/**
 * @author lwf
 * @title: Users
 * @projectName 11_02Ojdbc
 * @description: TODO
 * @date 2020/11/221:23
 */
public class Users {
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
