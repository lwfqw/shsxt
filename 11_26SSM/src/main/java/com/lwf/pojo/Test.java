package com.lwf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lwf
 * @title: Test
 * @projectName 11_24springMVC
 * @description: TODO
 * @date 2020/11/2417:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Test implements Serializable {
    private String name;
    private String city;
}
