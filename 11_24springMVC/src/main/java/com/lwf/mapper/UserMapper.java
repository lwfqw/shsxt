package com.lwf.mapper;

import com.lwf.pojo.User;

import java.util.List;

/**
 * @author lwf
 * @title: UserMapper
 * @projectName 11_24springMVC
 * @description: TODO
 * @date 2020/11/2519:44
 */
public interface UserMapper {
    List<User> queryAll();
}
