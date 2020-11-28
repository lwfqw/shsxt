package com.lwf.service;

import com.lwf.MyException.TransforException;
import com.lwf.mapper.UserMapper;
import com.lwf.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    public boolean transfor(String from, String to, BigDecimal money){
        try {
            boolean transfor = userMapper.transfor(from, money.negate());
            //int a=1/0;
            boolean transfor1 = userMapper.transfor(to, money);
            if(transfor&&transfor1){
                return true;
            }
        }catch (Exception e){
            throw new TransforException();
        }
        return false;
    }
}
