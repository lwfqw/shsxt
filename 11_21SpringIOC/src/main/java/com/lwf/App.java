package com.lwf;

import com.lwf.pojo.Dog;
import com.lwf.pojo.Panda;
import com.lwf.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        Panda panda = (Panda) context.getBean("panda");
        System.out.println(panda.toString());
        //ApplicationContext context=new FileSystemXmlApplicationContext("C:\\Users\\lwf\\IdeaProjects\\11_21SpringIOC\\src\\main\\resources\\beans.xml");
//        System.out.println(context.getBean("user"));
//        //引用
//        System.out.println(context.getBean("userService"));
//        //静态非静态方法工厂
//        UserService userS1 = (UserService) context.getBean("userS1");
//        UserService userS2 = (UserService) context.getBean("userS2");
//        System.out.println(userS1.one());
//        System.out.println(userS2.one());
//        Dog dog = (Dog) context.getBean("dog");
//        System.out.println(dog);
    }
}
