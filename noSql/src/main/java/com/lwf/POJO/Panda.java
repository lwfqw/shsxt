package com.lwf.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author lwf
 * @title: Panda
 * @projectName noSql
 * @description: TODO
 * @date 2020/10/2720:02
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Panda {
    private int age;
    private String name;
    private String city;
}
