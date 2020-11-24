import com.lwf.controller.UserController;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lwf
 * @title: Test
 * @projectName 11_23AOP
 * @description: TODO
 * @date 2020/11/2311:31
 */
public class Test {
    BeanFactory beanFactory;
    @Before
    public void bef(){
        beanFactory=new ClassPathXmlApplicationContext("spring.xml");
    }
    @org.junit.Test
    public void test(){
        UserController userController = (UserController) beanFactory.getBean("userController");
        System.out.println(userController);
        System.out.println(userController.check("lwf", "12345"));

    }
}
