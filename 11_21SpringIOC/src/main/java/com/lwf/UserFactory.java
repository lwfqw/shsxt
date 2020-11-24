package com.lwf;

import com.lwf.service.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author lwf
 * @title: UserFactory
 * @projectName 11_21SpringIOC
 * @description: TODO
 * @date 2020/11/2114:51
 */
@Setter
public class UserFactory {
    private UserService userService;
    public UserService getUserService(){
        return userService;
    }
}
