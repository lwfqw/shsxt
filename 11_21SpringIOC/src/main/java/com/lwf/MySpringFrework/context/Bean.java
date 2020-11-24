package com.lwf.MySpringFrework.context;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author lwf
 * @title: Bean
 * @projectName 11_21SpringIOC
 * @description: bean，放id，对象实例（getBean为空创建），还有属性名和值
 * @date 2020/11/2111:05
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Bean {
    private String id;
    private Object object;
    private String cla;
    private Map<String,Object> properties;
}
