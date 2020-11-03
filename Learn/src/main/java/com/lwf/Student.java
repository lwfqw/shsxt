package com.lwf;

import java.io.Serializable;

/**
 * @author lwf
 * @title: Student
 * @projectName Learn
 * @description: TODO
 * @date 2020/10/2019:56
 */

@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class Student implements Serializable, Cloneable {
    private String name;
    private Integer age;
    private String className;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
