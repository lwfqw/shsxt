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
        //ReflectUtils<Student> utils=new OracleJDBCUtils<>("oracle.properties");
        //反射获取对应类在数据库的表(表名与类名，属性名与列名相等)
        //查询
        utils.query(Student.class).forEach(System.out::println);
        //System.out.println(utils1.query(Sc.class));
        //删除
//        Student student=new Student();
//        student.setSno("9512101");
//        utils.delete(student);


//          Sc sc=new Sc();
//          sc.setSno("9521105");
//          utils.delete(sc);
         //更新
//        Sc sc=new Sc();
//        sc.setCno("c06");
//        sc.setSno("9531101");
//        utils.update(sc, "sno");
        //插入
//        Student student=new Student();
//        student.setSno("9531103");
//        student.setSage(34);
//        student.setSname("周永日");
//        student.setSdept("信息系");
//        utils.insert(student);
    }
}
