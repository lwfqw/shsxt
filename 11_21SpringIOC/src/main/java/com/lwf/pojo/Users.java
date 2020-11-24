package com.lwf.pojo;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author lwf
 * @title: Users
 * @projectName 11_21SpringIOC
 * @description: TODO
 * @date 2020/11/219:57
 */
@ToString

public class Users{
    private String name;
    private Integer age;

    public Users() {
        System.out.println("无参构造");
    }

    public String getName() {
        return name;
    }

    public void setName(Object name) {
        System.out.println("setting");
        this.name = (String) name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Object age) {
        this.age = Integer.valueOf( age+"");
    }
}
