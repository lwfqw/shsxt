package classTest.Mybatis.Emtity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author lwf
 * @title: Production
 * @projectName 11_3OracleJavaDay2Code
 * @description: TODO
 * @date 2020/11/49:20
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Production {
    private Integer id;
    private String name;
    private Integer have;
    private String place;
    private Float price;
}
