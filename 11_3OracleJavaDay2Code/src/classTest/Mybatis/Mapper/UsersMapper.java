package classTest.Mybatis.Mapper;

import classTest.Mybatis.Emtity.Users;

import java.util.List;

/**
 * @author lwf
 * @title: UsersMapper
 * @projectName 11_3OracleJavaDay2Code
 * @description: TODO
 * @date 2020/11/49:17
 */
public interface UsersMapper {
    String queryPassword(Integer id);
    Users queryById(Integer id);
    List<Users> queryAll();
    boolean updateByid(Users users);
    boolean insert(Users users);
    boolean delete(Integer id);
}
