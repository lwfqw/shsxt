package classTest.Mybatis.Mapper;

import classTest.Mybatis.Emtity.Emp;

import java.util.List;

/**
 * @author lwf
 * @title: EmpMapper
 * @projectName 11_3OracleJavaDay2Code
 * @description: TODO
 * @date 2020/11/418:52
 */
public interface EmpMapper {
    List<Emp> queryByDept(Integer deptno);
    List<Emp> query();
}
