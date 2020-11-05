package Mybatis.Emtity;

import lombok.*;

import java.io.Serializable;

/**
 * @author lwf
 * @title: Users
 * @projectName 11_5MybatisReview
 * @description: TODO
 * @date 2020/11/519:21
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Users implements Serializable {
    private Integer id;
    private String name;
    private String password;
}
