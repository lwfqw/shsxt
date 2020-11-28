package com.lwf.springbootstart.service;

import com.lwf.springbootstart.mapper.UserMapper;
import com.lwf.springbootstart.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lwf
 * @title: UserService
 * @projectName spring-boot-start
 * @description: TODO
 * @date 2020/11/2719:21
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;
    public List<User> queryAll(){return userMapper.queryAll();}
    public User queryOne(Integer id){ return userMapper.queryOne(id);}
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,String> login(Integer id,String password){
        Map<String,String> map=new HashMap<>();
        User user=queryOne(id);
        if(user==null){
            map.put("code", "400");
            map.put("msg", "账号不存在");

            return map;
        }
        if(user.getPassword().equals(password)){
            map.put("code", "200");
            map.put("msg", "账号密码正确");
        }else {
            map.put("code", "400");
            map.put("msg", "密码错误");
        }
        return map;
    }
}
