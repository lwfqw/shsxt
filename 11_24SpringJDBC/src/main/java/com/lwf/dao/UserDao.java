package com.lwf.dao;

import com.lwf.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author lwf
 * @title: UserDao
 * @projectName 11_24SpringJDBC
 * @description: TODO
 * @date 2020/11/249:52
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Map<String, Object>> queryAll(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from user");
        return maps;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer insert(User user){
        Integer update = jdbcTemplate.update("insert into user values(?,?,?,?,?)",user.getEmail(),user.getTel(),user.getName(),user.getPassword(),user.getBanlence());
        return update;
    }
}
