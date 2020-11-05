package Mybatis.Emtity;

import lombok.*;

import java.io.Serializable;

/**
 * @author lwf
 * @title: Buy
 * @projectName 11_5MybatisReview
 * @description: TODO
 * @date 2020/11/519:25
 */
public class Buy implements Serializable {
    private Integer id;
    private Integer pid;
    private Integer buy;
    private Users users;
    private Product product;

    public Buy() {
    }

    public Buy(Integer id, Integer pid, Integer buy, Users users, Product product) {
        this.id = id;
        this.pid = pid;
        this.buy = buy;
        this.users = users;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getBuy() {
        return buy;
    }

    public void setBuy(Integer buy) {
        this.buy = buy;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Buy{" +
                "id=" + id +
                ", pid=" + pid +
                ", buy=" + buy +
                ", users=" + users +
                ", product=" + product +
                '}';
    }
}
