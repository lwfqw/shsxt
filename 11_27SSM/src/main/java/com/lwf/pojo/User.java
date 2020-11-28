package com.lwf.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author lwf
 * @title: User
 * @projectName 11_24springMVC
 * @description: TODO
 * @date 2020/11/2519:40
 */
@Data
public class User implements Serializable {
    private String email;
    private String tel;
    private String name;
    private String password;
    private BigDecimal banlence;
}
