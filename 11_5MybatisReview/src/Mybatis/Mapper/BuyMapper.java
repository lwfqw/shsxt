package Mybatis.Mapper;

import Mybatis.Emtity.Buy;

import java.util.List;

/**
 * @author lwf
 * @title: BuyMapper
 * @projectName 11_5MybatisReview
 * @description: TODO
 * @date 2020/11/520:27
 */
public interface BuyMapper {
List<Buy> all();
List<Buy> allDetial();
List<Buy> userByUid(Integer id);
int update(Buy buy);
int delete(Buy buy);
int insert(Buy buy);
}
