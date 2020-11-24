package com.lwf;

import com.lwf.service.UserService;
import com.lwf.service.impl.UserServiceIMPL;

/**
 * @author lwf
 * @title: UserStaticFactory
 * @projectName 11_21SpringIOC
 * @description: TODO
 * @date 2020/11/2114:51
 */
public class UserStaticFactory {
    private static UserService userService;

    static {
        userService = new UserServiceIMPL();
    }

    public static UserService getUserService() {
        return userService;
    }
}
