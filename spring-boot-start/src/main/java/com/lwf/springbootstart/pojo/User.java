package com.lwf.springbootstart.pojo;

import lombok.Data;
import org.springframework.data.relational.core.sql.In;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author lwf
 * @title: User
 * @projectName spring-boot-start
 * @description: TODO
 * @date 2020/11/2718:31
 */
@Data
public class User implements Serializable {
private Integer id;
private String name;
private String password;
private BigDecimal money;
}
