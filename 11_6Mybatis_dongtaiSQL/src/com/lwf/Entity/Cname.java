package com.lwf.Entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author lwf
 * @title: Cname
 * @projectName 11_6Mybatis_dongtaiSQL
 * @description: TODO
 * @date 2020/11/615:05
 */
@Data
public class Cname {
    private String cno;
    private String name;
    private List<Students> students;
    @Override
    public String toString() {
        return "Cname{" +
                "cno='" + cno + '\'' +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
