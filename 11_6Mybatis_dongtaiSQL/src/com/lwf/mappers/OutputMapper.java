package com.lwf.mappers;

import com.lwf.Entity.Output;

import java.util.List;

/**
 * @author lwf
 * @title: OutputMapper
 * @projectName 11_6Mybatis_dongtaiSQL
 * @description: TODO
 * @date 2020/11/621:05
 */
public interface OutputMapper {
    int insertSome(List<Output> list);
    int pridict();
    List<Output> all();
    Output queryByYear(Integer year);
}
