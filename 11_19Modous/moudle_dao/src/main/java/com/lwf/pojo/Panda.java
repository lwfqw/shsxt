package com.lwf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lwf
 * @title: Panda
 * @projectName 11_19Modous
 * @description: TODO
 * @date 2020/11/1915:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Panda implements Serializable {
    private String name;
    private Integer age;
    private String from;
}
