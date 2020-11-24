package com.lwf.service.impl;

import com.lwf.pojo.Users;
import com.lwf.service.UserService;
import lombok.Data;

import java.util.List;

/**
 * @author lwf
 * @title: UserServiceIMPL
 * @projectName 11_21SpringIOC
 * @description: TODO
 * @date 2020/11/2110:29
 */
@Data
public class UserServiceIMPL implements UserService {
    Users users;
    @Override
    public Users one() {
        return users;
    }
}
