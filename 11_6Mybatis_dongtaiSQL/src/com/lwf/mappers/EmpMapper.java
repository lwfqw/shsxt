package com.lwf.mappers;
import com.lwf.Entity.Emp;

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
    List<Emp> queryByMgrDept(Integer mgr, Integer deptno);
    List<Emp> queryByMgrDeptComm(Integer mgr, Integer deptno, Float comm);

    int deleteSomeEmpno(List<Integer> dnos);
    int insertSome(List<Emp> list);
    int updateSome(List<Emp> list);

    int update(Emp emp);
}
