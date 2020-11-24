package com.lwf.service;

import com.lwf.mapper.UserMapper;
import com.lwf.pojo.MSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lwf
 * @title: UserService
 * @projectName 11_23AOP
 * @description: TODO
 * @date 2020/11/2311:22
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public MSG check(String name,String password){
        if(name==null||name.trim().equals("")){
            return new MSG(300,"名为空");
        }
        if(password==null||password.trim().equals("")){
            return new MSG(300,"密码空");
        }
        return userMapper.check(name, password);
    }
}
