package com.lwf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lwf
 * @title: User
 * @projectName 11_20fremark
 * @description: TODO
 * @date 2020/11/209:41
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
}
