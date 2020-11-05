package Mybatis;
import Mybatis.Mapper.EmpMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;

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
        System.out.println(empMapper.queryByidToMap(1111));
        empMapper.queryBydeptToMap(30).forEach(System.out::println);
//        System.out.println(empMapper.queryByDept(30).size());
//        empMapper.query().forEach(System.out::println);
//        empMapper.queryArray(new Integer[]{1111,5489,7782}).forEach(System.out::println);
//        System.out.println("-----");
//        empMapper.queryList(new ArrayList<Integer>(Arrays.asList(new Integer[]{1111, 5489, 7782}))).forEach(System.out::println);
//
//        //Dept
//        DeptMapper deptMapper=sqlSession.getMapper(DeptMapper.class);
//        System.out.println(deptMapper.queryById(30));
        sqlSession.commit();
        sqlSession.close();
        }
}
