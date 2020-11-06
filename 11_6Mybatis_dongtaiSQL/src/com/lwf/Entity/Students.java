package com.lwf.Entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author lwf
 * @title: Students
 * @projectName 11_6Mybatis_dongtaiSQL
 * @description: TODO
 * @date 2020/11/615:05
 */
@Data
public class Students {
    private Integer id;
    private String name;
    private String sex;
    private String cno;
    private Cname cname;

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", cno='" + cno + '\'' +
                ", cname=" + cname +
                '}';
    }
}
