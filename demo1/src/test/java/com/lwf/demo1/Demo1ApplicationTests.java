package com.lwf.demo1;

import com.lwf.demo1.dao.PandaDao;
import com.lwf.demo1.pojo.Panda;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}
