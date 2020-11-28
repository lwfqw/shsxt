package com.lwf.mapper;

import com.lwf.pojo.User;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author lwf
 * @title: UserMapper
 * @projectName 11_24springMVC
 * @description: TODO
 * @date 2020/11/2519:44
 */
public interface UserMapper {
    //全部用户
    List<User> queryAll();
    //查一个
    User queryByEmail(String email);
    //更新余额，转账两个配合使用
    boolean transfor(String give, BigDecimal money);
}
