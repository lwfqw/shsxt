package Mybatis.Mapper;

import Mybatis.Emtity.Emp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
    List<Emp> queryArray(Integer[] arrays);
    List<Emp> queryList(List<Integer> list);
    Map<String,Object> queryByidToMap(Integer no);
    List<Map<String,Object>> queryBydeptToMap(Integer deptno);
}
