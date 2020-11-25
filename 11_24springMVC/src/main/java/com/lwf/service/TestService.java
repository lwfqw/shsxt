package com.lwf.service;

import com.lwf.pojo.Test;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lwf
 * @title: TestService
 * @projectName 11_24springMVC
 * @description: TODO
 * @date 2020/11/2417:48
 */
@Service
public class TestService {
    private List<Test> user=new ArrayList<>();
    {
        Test test=new Test("lwf","jx");
        Test test1=new Test("lwf1","jx");
        user.add(test);
        user.add(test1);
    }
    public List<Test> tests(){return user;}
}
