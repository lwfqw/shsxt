package com.lwf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lwf
 * @title: User
 * @projectName 11_17ServletFilter
 * @description: TODO
 * @date 2020/11/1711:44
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User implements Serializable {
    private String name;
    private Integer age;
    private String place;
}
