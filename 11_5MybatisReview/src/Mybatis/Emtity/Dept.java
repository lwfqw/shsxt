package Mybatis.Emtity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author lwf
 * @title: Dept
 * @projectName 11_3OracleJavaDay2Code
 * @description: TODO
 * @date 2020/11/419:29
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Dept implements Serializable {
    private Integer deptno;
    private String dname;
    private String loc;
    private List<Emp> emps;

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                ", emps=" + emps +
                '}';
    }
}
