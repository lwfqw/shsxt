package com.lwf.demo1.dao;

import com.lwf.demo1.pojo.Panda;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author lwf
 * @title: PandaDao
 * @projectName demo1
 * @description: TODO
 * @date 2020/10/2821:17
 */
@Mapper
public interface PandaDao {
    @Select("select * from panda")
    List<Panda> allPanda();
    @Insert("insert into panda(name,age,city) values(#{name},#{age},#{city})")
    boolean insert(Panda panda);
    @Delete("delete from panda where name=#{name}")
    boolean delete(String name);
    @Update("update panda set age=#{age},city=#{city} where name=#{name}")
    boolean update(Panda panda);
}
