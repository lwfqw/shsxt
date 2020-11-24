package com.lwf.MySpringFrework.context;

import lombok.Data;
import java.util.HashMap;
import java.util.Map;
@Data
/**
 * @author lwf
 * @title: MyClassPathXmlContent
 * @projectName 11_21SpringIOC
 * @description: TODO
 * @date 2020/11/2111:01
 */
public class MyClassPathXmlContent implements BeanFactory {
    private Map<String,Bean> context=new HashMap<>();
    public MyClassPathXmlContent(String path) throws Exception {
        context=LoadBean.load(path);
    }
    @Override
    public Object getBean(String id) throws Exception {
        return context.get(id).getObject();
    }
}
