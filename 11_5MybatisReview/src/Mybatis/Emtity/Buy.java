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
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Buy implements Serializable {
    private Integer id;
    private Integer pid;
    private Integer buy;
    private Users users;
    private Product product;
}
