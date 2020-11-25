package com.lwf;

import static org.junit.Assert.assertTrue;

import com.lwf.controller.UserController;
import com.lwf.dao.UserDao;
import com.lwf.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class JdbcTemplateTest
{
    @Autowired
    UserDao userDao;
    @Test
    public void shouldAnswerWithTrue()
    {
        userDao.queryAll().forEach(System.out::println);
        userDao.insert(new User("lshlearn@sina.com","13676893456","lsh","asdf",new BigDecimal(250)));
        userDao.queryAll().forEach(System.out::println);
    }
}
