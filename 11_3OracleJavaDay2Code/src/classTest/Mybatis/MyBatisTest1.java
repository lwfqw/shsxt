package classTest.Mybatis;

import classTest.Mybatis.Emtity.Production;
import classTest.Mybatis.Emtity.Student;
import classTest.Mybatis.Emtity.Users;
import classTest.Mybatis.Mapper.ProductionMapper;
import classTest.Mybatis.Mapper.StudentMapper;
import classTest.Mybatis.Mapper.UsersMapper;
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
        //studentMapper测试
//        StudentMapper mapper = (StudentMapper) sqlSession.getMapper(StudentMapper.class);
//        mapper.queryAll().forEach(System.out::println);
//        System.out.println("---------------------查一个");
//        System.out.println(mapper.queryBySno("9521105"));
//        System.out.println("---------------------- 更新");
//        mapper.update(new Student("9521105", "罗日天", 20,'男', "信息学院"));
//        System.out.println(mapper.queryBySno("9521105"));
//        System.out.println("-----------------------插入");
//        mapper.insert(new Student("9521106", "日天",21,'男', "信息学院"));
//        System.out.println(mapper.queryBySno("9521106"));
//        mapper.delete(new Student("9521106", "日天", 21,'男', "信息学院"));
//userMapper测试
//        UsersMapper usersMapper=sqlSession.getMapper(UsersMapper.class);
//        System.out.println(usersMapper.queryPassword(1));
//        System.out.println(usersMapper.queryById(1));
//        usersMapper.insert(new Users(4, "周永日", "123456", "12345678901"));
//        usersMapper.queryAll().forEach(System.out::println);
//        usersMapper.updateByid(new Users(1, "罗卫飞", "123456", "22222222222"));
//        usersMapper.delete(4);
   //测试注解curd
        ProductionMapper productionMapper=sqlSession.getMapper(ProductionMapper.class);
        productionMapper.queryAll().forEach(System.out::println);
        System.out.println(productionMapper.queryByid(2));
        System.out.println(productionMapper.queryByname("神船"));
        Production production = new Production(4, "键盘", 123, "上海", (float) 250);
        productionMapper.insert(production);
        System.out.println(productionMapper.queryByid(4));
        System.out.println(productionMapper.delete(4));
        production.setId(2);
        production.setName("键盘侠神器");
        productionMapper.updateAllByid(production);
        System.out.println(productionMapper.queryBynameToShow("键盘侠神器"));
        sqlSession.commit();
        sqlSession.close();
        }
}
