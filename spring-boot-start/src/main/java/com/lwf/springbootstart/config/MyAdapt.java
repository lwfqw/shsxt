package com.lwf.springbootstart.config;

import com.lwf.springbootstart.intercepter.GlobalIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author lwf
 * @title: MyAdapt
 * @projectName spring-boot-start
 * @description: TODO
 * @date 2020/11/2721:45
 */
@Configuration
public class MyAdapt extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new GlobalIntercepter())
                .addPathPatterns("")
                .excludePathPatterns();
        super.addInterceptors(registry);

    }
}
