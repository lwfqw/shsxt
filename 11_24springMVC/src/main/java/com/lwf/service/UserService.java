package com.lwf.service;

import com.lwf.mapper.UserMapper;
import com.lwf.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lwf
 * @title: UserService
 * @projectName 11_24springMVC
 * @description: TODO
 * @date 2020/11/2519:47
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public List<User> queryAll(){
        return userMapper.queryAll();
    }
    public boolean check(String email,String password){
        return userMapper.queryByEmail(email).getPassword().equals(password);
    }
    public User getByEmail(String email){
        return userMapper.queryByEmail(email);
    }
}
