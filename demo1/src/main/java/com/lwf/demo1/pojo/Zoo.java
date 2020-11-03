package com.lwf.demo1.pojo;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author lwf
 * @title: Zoo
 * @projectName demo1
 * @description: @value注入值
 * @date 2020/10/2819:29
 */
@Component
@PropertySource(value = "classpath:text.properties")
@Configuration
@Data
public class Zoo {
    @Value("${zoo.name}")
    private String name;
    @Value("${zoo.locate}")
    private String locate;
    @Value("${zoo.information}")
    private String infomation;
}
