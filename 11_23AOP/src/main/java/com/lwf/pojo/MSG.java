package com.lwf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lwf
 * @title: MSG
 * @projectName 11_23AOP
 * @description: TODO
 * @date 2020/11/2310:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MSG implements Serializable {
    private Integer code=200;
    private String msg="success";
}
