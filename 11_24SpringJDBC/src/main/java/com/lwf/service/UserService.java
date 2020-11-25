package com.lwf.service;

import com.lwf.dao.UserDao;
import com.lwf.mappers.UserMapper;
import com.lwf.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author lwf
 * @title: UserService
 * @projectName 11_24SpringJDBC
 * @description: TODO
 * @date 2020/11/249:52
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;//jdbcTemplate
    @Autowired
    private UserMapper userMapper;//mybatis
    public List<Map<String, Object>> queryAll(){
        return userDao.queryAll();
    }
    public List<User> allMybatis(){
        return userMapper.all();
    }
    public User queryByEmail(String email){
        return userMapper.queryByEmail(email);
    }
     @Transactional(propagation = Propagation.REQUIRED)
    public boolean out(String email, BigDecimal decimal){return userMapper.out(email,decimal );}
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean in(String email, BigDecimal decimal){return userMapper.in(email,decimal );}
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean transfor(String from,String to,BigDecimal money){
        boolean out = userMapper.out(from, money);
        boolean in = userMapper.in(to, money);
        if(in&&out){
            return true;
        }
        return false;
    }
}
