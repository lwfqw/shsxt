package com.lwf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author lwf
 * @title: User
 * @projectName 11_24SpringJDBC
 * @description: TODO
 * @date 2020/11/249:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private String email;
    private String tel;
    private String name;
    private String password;
    private BigDecimal banlence;
}
