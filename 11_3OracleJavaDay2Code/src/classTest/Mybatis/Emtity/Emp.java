package classTest.Mybatis.Emtity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lwf
 * @title: Emp
 * @projectName 11_3OracleJavaDay2Code
 * @description: TODO
 * @date 2020/11/418:47
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Emp implements Serializable {
    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private Date hiredate;
    private Double sal;
    private Double comm;
    private Integer deptno;
}
