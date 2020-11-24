package com.lwf.mappers;

import com.lwf.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lwf
 * @title: UserMapper
 * @projectName 11_20fremark
 * @description: TODO
 * @date 2020/11/2020:55
 */
@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> all();
}
