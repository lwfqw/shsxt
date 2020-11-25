package com.lwf.mappers;

import com.lwf.pojo.User;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author lwf
 * @title: UserMapper
 * @projectName 11_24SpringJDBC
 * @description: TODO
 * @date 2020/11/2411:30
 */
@Repository
public interface UserMapper {
    List<User> all();
    User queryByEmail(String email);
    boolean out(String email, BigDecimal out);
    boolean in(String email, BigDecimal in);
}
