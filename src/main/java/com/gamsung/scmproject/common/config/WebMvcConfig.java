package com.gamsung.scmproject.common.config;

import com.gamsung.scmproject.common.interceptor.RequestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

//    private List<String> pathList;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(new RequestInterceptor())
                .addPathPatterns(
                        "/delivery/management",
                        "/api/batch/delivery/test",
                        "/api/delivery/list/search"
                )
                .addPathPatterns(
                        "/deliveryStaff/management",
                        "/deliveryStaff/registration"
                        )
                .addPathPatterns("/deliveryStaff/management","/deliveryStaff/registration")
        ;
    }
}
