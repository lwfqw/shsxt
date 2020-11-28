package com.lwf.springbootstart.mapper;

import com.lwf.springbootstart.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

/**
 * @author lwf
 * @title: UserMapper
 * @projectName spring-boot-start
 * @description: TODO
 * @date 2020/11/2719:20
 */
@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> queryAll();
    @Select("select * from user where id=#{id}")
    User queryOne(Integer id);
}
