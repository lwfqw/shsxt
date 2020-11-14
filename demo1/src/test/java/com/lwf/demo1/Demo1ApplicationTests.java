package com.lwf.demo1;

import com.lwf.demo1.dao.PandaDao;
import com.lwf.demo1.pojo.Panda;
import com.lwf.demo1.utils.SpringMail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.net.MalformedURLException;

@SpringBootTest
class Demo1ApplicationTests {
    @Autowired
    @SuppressWarnings("all")
   private PandaDao pandaDao;
    @Test
    void contextLoads() {
        System.out.println(pandaDao.allPanda());
        Panda panda=new Panda();
        panda.setName("雪宝");
        panda.setAge(1);
        panda.setCity("上海浦东");
        //pandaDao.update(panda);
    }
        @Autowired
        private SpringMail mail;
        @Autowired
        TemplateEngine templateEngine;
        @Test
        public void send() throws MalformedURLException {
//            mail.setSender("519155720@qq.com","helloWorld","" +
//                    "hello my first mail!");
//            mail.setSender("519155720@qq.com","helloWorld",new URL("https://blog.csdn.net/lwf0615?spm=1001.2101.3001.5113"));
            Context context=new Context();
            context.setVariable("name", "憨批");
            String process = templateEngine.process("/mail/mail.html", context);
            mail.setSender("632593482@qq.com","helloWorld",process);

        }
}
