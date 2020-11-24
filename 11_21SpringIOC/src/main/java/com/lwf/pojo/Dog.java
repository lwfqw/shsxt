package com.lwf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author lwf
 * @title: Dog
 * @projectName 11_21SpringIOC
 * @description: TODO
 * @date 2020/11/2115:16
 */
@Component("dog")
@Data
@NoArgsConstructor
public class Dog {
    @Value("二哈")
    private String name;
    @Value("2")
    private Integer age;

    public Dog(String name, Integer age) {
        System.out.println("gog全参");
        this.name = name;
        this.age = age;
    }
}
