package classTest.Mybatis.Mapper;

import classTest.Mybatis.Emtity.Student;

import java.util.List;

/**
 * @author lwf
 * @title: StudentMapper
 * @projectName 11_3OracleJavaDay2Code
 * @description: TODO
 * @date 2020/11/315:16
 */
public interface StudentMapper {
    List<Student> queryAll();
    Student queryBySno(String sno);
    void update(Student student);
    void delete(Student student);
    void insert(Student student);
}
