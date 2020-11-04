package classTest.Mybatis.Mapper;

import classTest.Mybatis.Emtity.Production;
import classTest.Mybatis.Emtity.Show;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author lwf
 * @title: ProductionMapper
 * @projectName 11_3OracleJavaDay2Code
 * @description: TODO
 * @date 2020/11/49:23
 */
@Mapper
public interface ProductionMapper {
    @Results(id = "show",value = {
            @Result(column = "name", property = "name"),
            @Result(column = "have",property = "have"),
            @Result(column = "place",property = "place"),
            @Result(column = "price",property = "price")
    })
    /**
     * 查询所有商品
     * @return
     */
    @Select("select * from production")
   List<Production> queryAll();

    /**
     * 根据id查询商品
     * @param id
     * @return
     */
    @Select("select * from production where id=#{id}")
    Production queryByid(Integer id);

    /**
     * 根据名字查商品
     * @param name
     * @return
     */
    @Select("select * from production where name=#{name}")
    List<Production> queryByname(String name);
    //结果集映射
    @Select("select * from production where name=#{name}")
    @ResultMap("show")
    List<Show> queryBynameToShow(String name);
    /**
     * 根据产地查询商品
     * @param place
     * @return
     */
    @Select("select * from production where place=#{place}")
    List<Production> queryByplace(String place);

    /**
     * 更新数量
     * @param have
     * @param id
     * @return
     */
    @Update("update production set have=#{have} where id=#{id}")
    boolean updateHave(Integer have,Integer id);
    /**
     * 更新名字
     * @param name
     * @param id
     * @return
     */
    @Update("update production set name=#{name} where id=#{id}")
    boolean updateName(String name,Integer id);
    /**
     * 更新价格
     * @param price
     * @param id
     * @return
     */
    @Update("update production set price=#{price} where id=#{id}")
    boolean updatePrice(Float price,Integer id);

    /**
     * id更新所有
     * @param production
     * @return
     */
    @Update("update production set name=#{name} ,have=#{have},price=#{price},place=#{place} where id=#{id}")
    boolean updateAllByid(Production production);
    //根据id删除
    @Delete("delete from production where id=#{id}")
    boolean delete(Integer id);
    //插入
    @Insert("insert into production values(#{id},#{name},#{have},#{place} ,#{price})")
    boolean insert(Production production);
}
