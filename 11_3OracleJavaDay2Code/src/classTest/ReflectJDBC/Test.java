package classTest.ReflectJDBC;

import classTest.POJO.Student;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * @author lwf
 * @title: Test
 * @projectName 11_02Ojdbc
 * @description: 测试反射jdbc工具类
 * @date 2020/11/219:46
 */
public class Test {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        ReflectUtils<Student> utils=new OracleJDBCUtils<>("oracle.properties");
        utils.query(Student.class).forEach(System.out::println);
        utils.close();
    }
}
