package classTest.Mybatis.Emtity;

import lombok.*;

import java.io.Serializable;

/**
 * @author lwf
 * @title: Student
 * @projectName 11_3OracleJavaDay2Code
 * @description: TODO
 * @date 2020/11/315:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private String sno;
    private String sname;
    private Integer sage;
    private Character ssex;
    private String sdept;
}
