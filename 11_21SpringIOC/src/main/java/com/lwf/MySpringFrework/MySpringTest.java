package com.lwf.MySpringFrework;

import com.lwf.MySpringFrework.context.MyClassPathXmlContent;
import com.lwf.pojo.Panda;
import com.lwf.pojo.Users;

import java.lang.reflect.InvocationTargetException;

/**
 * @author lwf
 * @title: MySpringTest
 * @projectName 11_21SpringIOC
 * @description: TODO
 * @date 2020/11/2111:39
 */
public class MySpringTest {
    public static void main(String[] args) throws Exception {
       // MyClassPathXmlContent content=new MyClassPathXmlContent("C:\\Users\\lwf\\IdeaProjects\\11_21SpringIOC\\src\\main\\resources\\beans.xml");
        MyClassPathXmlContent content=new MyClassPathXmlContent("Mybeans.xml");
        Users user = (Users) content.getBean("user");
        System.out.println(user);
        Panda panda = (Panda) content.getBean("panda");
        System.out.println(panda);
        System.out.println(panda.getCity());
        content.getBean("panda");
    }
}
