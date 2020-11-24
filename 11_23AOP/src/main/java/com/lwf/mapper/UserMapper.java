package com.lwf.mapper;

import com.lwf.pojo.MSG;
import com.lwf.pojo.User;
import org.graalvm.compiler.nodeinfo.StructuralInput;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lwf
 * @title: UserMapper
 * @projectName 11_23AOP
 * @description: TODO
 * @date 2020/11/2310:38
 */
@Repository
public class UserMapper implements Serializable {
    Map<String,User> DB=new HashMap<>();
    {
        User user=new User();
        user.setName("lwf");
        user.setAge(18);
        user.setPassword("12345");
        DB.put(user.getName(), user);
    }
    public MSG check(String name,String password){
        MSG msg = new MSG();
        if (!DB.containsKey(name)) {
            msg.setCode(300);
            msg.setMsg("用户不存在");
        }else {
            if(!password.equals(DB.get(name).getPassword())){
                msg.setMsg("密码错误");
            }
        }
        return msg;
    }
}
