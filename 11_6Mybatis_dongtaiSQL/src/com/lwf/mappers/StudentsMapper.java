package com.lwf.mappers;

import com.lwf.Entity.Students;

import java.util.List;

/**
 * @author lwf
 * @title: StudentsMapper
 * @projectName 11_6Mybatis_dongtaiSQL
 * @description: TODO
 * @date 2020/11/615:06
 */
public interface StudentsMapper {
    List<Students> query();
    List<Students> queryDetail();
}
