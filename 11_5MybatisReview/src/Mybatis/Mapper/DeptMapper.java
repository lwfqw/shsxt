package Mybatis.Mapper;

import Mybatis.Emtity.Dept;

/**
 * @author lwf
 * @title: DeptMapper
 * @projectName 11_3OracleJavaDay2Code
 * @description: TODO
 * @date 2020/11/419:31
 */
public interface DeptMapper {
    Dept queryById(Integer deptno);
}
