package Mybatis.Mapper;

import Mybatis.Emtity.Users;

import java.util.List;

/**
 * @author lwf
 * @title: UsersMapper
 * @projectName 11_5MybatisReview
 * @description: TODO
 * @date 2020/11/519:28
 */
public interface UsersMapper {
    List<Users> getByName(String name);
    Users getById(Integer id);
    List<Users> all();

    int insert(Users users);
    int delete(Integer id);
    int update(Users users);
}
