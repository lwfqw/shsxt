package Mybatis;
import Mybatis.Emtity.Emp;
import Mybatis.Mapper.EmpMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author lwf
 * @title: MyBatisTest1
 * @projectName 11_3OracleJavaDay2Code
 * @description: TODO
 * @date 2020/11/315:03
 */
public class MyBatisTest1 {
    public static void main(String[] args) throws IOException {
        SqlSessionFactory sqlSessionFactory= new  SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml" ));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //EmpMapper
        EmpMapper empMapper=sqlSession.getMapper(EmpMapper.class);
        empMapper.query().forEach(System.out::println);
        Emp emp=new Emp(7935,"lwf","aaa", 1111, new Date(), 100d, 12d, 30);
        Emp emp1=new Emp(7936,"lwf","aaa", 1111, new Date(), 100d, 12d, 30);
        Emp emp2=new Emp(7937,"lwf","aaa", 1111, new Date(), 100d, 12d, 30);
        List<Emp> list=new ArrayList<>(Arrays.asList(new Emp[]{emp,emp1,emp2}));
        empMapper.insertSome(list);
        //System.out.println(empMapper.deleteSomeEmpno(new ArrayList<Integer>(Arrays.asList(new Integer[]{1111, 5489}))));
//        System.out.println(empMapper.queryByidToMap(1111));
//        empMapper.queryBydeptToMap(30).forEach(System.out::println);
//        empMapper.queryByMgrDept(7698, 30).forEach(System.out::println);
//        empMapper.queryByMgrDeptComm(7698, 30, 500f).forEach(System.out::println);

//        System.out.println(empMapper.queryByDept(30).size());
//        empMapper.query().forEach(System.out::println);
//        empMapper.queryArray(new Integer[]{1111,5489,7782}).forEach(System.out::println);
//        System.out.println("-----");
//        empMapper.queryList(new ArrayList<Integer>(Arrays.asList(new Integer[]{1111, 5489, 7782}))).forEach(System.out::println);
//
//        //Dept
//        DeptMapper deptMapper=sqlSession.getMapper(DeptMapper.class);
//        System.out.println(deptMapper.queryById(30));
       // sqlSession.commit();
        sqlSession.close();
        }
}
