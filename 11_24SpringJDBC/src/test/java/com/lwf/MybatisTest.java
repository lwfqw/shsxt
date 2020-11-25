package com.lwf;

import com.lwf.mappers.UserMapper;
import com.lwf.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

/**
 * @author lwf
 * @title: MybatisTest
 * @projectName 11_24SpringJDBC
 * @description: TODO
 * @date 2020/11/2411:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class MybatisTest {
    @Autowired
    private UserService userService;
    @Autowired
    UserMapper userMapper;
    @Test
    public void transfor(){
          userService.transfor("519155720@qq.com","lwf2020@163.com",new BigDecimal(60));
    }
    @Test
    public void all(){
     userService.allMybatis().forEach(System.out::println);
    }
}
