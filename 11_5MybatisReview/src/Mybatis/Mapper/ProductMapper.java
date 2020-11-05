package Mybatis.Mapper;

import Mybatis.Emtity.Product;

import java.util.List;

/**
 * @author lwf
 * @title: ProductMapper
 * @projectName 11_5MybatisReview
 * @description: TODO
 * @date 2020/11/520:06
 */
public interface ProductMapper {
    List<Product> all();
    Product getById(Integer id);
    List<Product> getByName(String name);
    int update(Product product);
    int insert(Product product);
    int delete(Integer pid);
}
