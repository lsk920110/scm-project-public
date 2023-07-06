package com.gamsung.scmproject.common.config;

import com.gamsung.scmproject.common.interceptor.RequestInterceptor;
import com.gamsung.scmproject.menubar.controller.MenuBarApiController;
import com.gamsung.scmproject.menubar.controller.MenuBarController;
import com.gamsung.scmproject.productCategory.controller.ProductCategoryController;
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
                .addPathPatterns(
                        "order/registration",
                        "order/management",
                        "order/update",
                        "/api/statement/insert",
                        "/api/statement/update",
                        "/api/order/insert",
                        "/api/order/list",
                        "/api/delete/statement",
                        "/api/delete/order")
                .addPathPatterns("/product/category",
                        "/api/product/category/list",
                        "/api/product/category")
                .addPathPatterns(ProductCategoryController.PRODUCT_CATEGORY_PATH)
                .addPathPatterns(
                        "/product/model/management",
                        "/product/model",
                        "/api/product/model"
                )
                .addPathPatterns(
                        "/vendor",
                        "/vendor/management",
                        "/vendor/registration"
                )
                .addPathPatterns(
                        "/salesInfo/management",
                        "/api/salesInfo/batch/test",
                        "/api/salesInfo"
                )
                .addPathPatterns(MenuBarController.MENU_BAR_PATH)
                .addPathPatterns(MenuBarApiController.MENU_BAR_API_PATH)
        ;
    }
}
