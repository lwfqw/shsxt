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
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product implements Serializable {
    private Integer pid;
    private String name;
    private Integer have;
    private String info;
}
