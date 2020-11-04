package classTest.Mybatis.Emtity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author lwf
 * @title: Users
 * @projectName 11_3OracleJavaDay2Code
 * @description: TODO
 * @date 2020/11/49:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Users {
    private Integer id ;
    private String name;
    private String password;
    private String tel;
}
