package Mybatis.Emtity;

import lombok.*;

import java.io.Serializable;

/**
 * @author lwf
 * @title: Product
 * @projectName 11_5MybatisReview
 * @description: TODO
 * @date 2020/11/519:23
 */
public class Product implements Serializable {
    private Integer pid;
    private String name;
    private Integer have;
    private String info;

    public Product() {
    }

    public Product(Integer pid, String name, Integer have, String info) {
        this.pid = pid;
        this.name = name;
        this.have = have;
        this.info = info;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHave() {
        return have;
    }

    public void setHave(Integer have) {
        this.have = have;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", have=" + have +
                ", info='" + info + '\'' +
                '}';
    }
}
