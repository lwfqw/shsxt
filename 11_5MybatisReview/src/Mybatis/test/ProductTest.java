package Mybatis.test;

import Mybatis.Emtity.Product;
import Mybatis.Emtity.Users;
import Mybatis.Mapper.ProductMapper;
import Mybatis.Mapper.UsersMapper;
import Mybatis.utils.SessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author lwf
 * @title: ProductTest
 * @projectName 11_5MybatisReview
 * @description: TODO
 * @date 2020/11/520:11
 */
public class ProductTest {
    SqlSession sqlSession=null;
    @Before
    public void before(){
        sqlSession=new SessionFactory().getSession();
    }
    @Test
    public void selectProduct(){
        ProductMapper mapper=sqlSession.getMapper(ProductMapper.class);
        mapper.all().forEach(System.out::println);
        System.out.println(mapper.getById(2));
        mapper.update(new Product(2, null, 12, null));
        mapper.insert(new Product(5, "qq", 123, "null"));
        mapper.delete(5);
    }
    @After
    public void after(){
        sqlSession.commit();
        sqlSession.close();
    }
}
