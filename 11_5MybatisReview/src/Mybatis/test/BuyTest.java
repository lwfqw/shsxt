package Mybatis.test;

import Mybatis.Emtity.Buy;
import Mybatis.Emtity.Product;
import Mybatis.Mapper.BuyMapper;
import Mybatis.Mapper.ProductMapper;
import Mybatis.utils.SessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author lwf
 * @title: BuyTest
 * @projectName 11_5MybatisReview
 * @description: TODO
 * @date 2020/11/520:28
 */
public class BuyTest {
    SqlSession sqlSession=null;
    @Before
    public void before(){
        sqlSession=new SessionFactory().getSession();
    }
    @Test
    public void selectProduct(){
        BuyMapper mapper=sqlSession.getMapper(BuyMapper.class);
        mapper.all().forEach(System.out::println);
        System.out.println("详细-------");
        mapper.allDetial().forEach(System.out::println);
        System.out.println("更新-------");
        System.out.println(mapper.update(new Buy(1, 4, 5, null, null)));
        System.out.println("插入-------");
        System.out.println(mapper.insert(new Buy(1, 2, 4, null, null)));
        System.out.println("删除-------");
        System.out.println(mapper.delete(new Buy(1, 2, 4, null, null)));
        mapper.userByUid(1).forEach(System.out::println);
    }
    @After
    public void after(){
        sqlSession.commit();
        sqlSession.close();
    }

}
