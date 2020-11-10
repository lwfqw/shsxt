package com.lwf.mappers;

import com.lwf.Entity.Users;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author lwf
 * @title: UsersMapper
 * @projectName 11_6Mybatis_dongtaiSQL
 * @description: TODO
 * @date 2020/11/619:11
 */
public interface UsersMapper {
    /**
     * 登录
     * @param id id
     * @return
     */
    @Select("select password from users where id=#{id}")
    String getPassword(Integer id);
    @Select("select * from users where id=#{id}")
    Users getUserById(Integer id);

    /**
     * 注册
     * @param users
     * @return
     */
    @Insert("insert into users values(#{id},#{name},#{password})")
    int insert(Users users);

    /**
     * 查最大主键
     * @return
     */
    @Select("select max(id) from users")
    Integer maxId();
    /**
     * 注销
     * @param id
     * @return
     */
    @Delete("delete from users where id=#{id}")
    int delete(Integer id);

    /**
     * 修改密码
     * @return
     */
    @Update("update users set name=#{name},password=#{password} where id=#{id}")
    int update(Users users);
}
