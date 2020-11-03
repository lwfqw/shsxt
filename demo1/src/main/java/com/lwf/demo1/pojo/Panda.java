package com.lwf.demo1.pojo;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author lwf
 * @title: Panda
 * @projectName demo1
 * @description:      @ConfigurationProperties(prefix = "panda") key前值
 *                    @PropertySource("classpath:text.properties") 路径
 * @date 2020/10/2817:48
 */
@Data
@Component
@ConfigurationProperties(prefix = "panda")
@PropertySource(value = "classpath:text.properties")
public class Panda {
    private String name;
    private Integer age;
    private String city;
}
