package com.lwf.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author lwf
 * @title: Panda
 * @projectName 11_27Annotation
 * @description: TODO
 * @date 2020/11/2716:04
 */
@Component
@PropertySource(value = "classpath:panda.properties",encoding = "UTF-8")
@Data
public class Panda {
    @Value("${name}")
    private String name;
    @Value("${age}")
    private Integer age;
    @Value("${city}")
    private String city;
}
