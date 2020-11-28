package com.lwf;

import com.lwf.configration.MyStart;
import com.lwf.pojo.Panda;
import com.lwf.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws UnsupportedEncodingException {
        ApplicationContext ac=new AnnotationConfigApplicationContext(MyStart.class);
        UserService bean = ac.getBean(UserService.class);
    }
}
