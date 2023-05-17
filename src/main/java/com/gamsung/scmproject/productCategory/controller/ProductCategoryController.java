package com.gamsung.scmproject.productCategory.controller;


import com.gamsung.scmproject.productCategory.model.ProductCategoryEntity;
import com.gamsung.scmproject.productCategory.service.ProductCategoryService;
import com.gamsung.scmproject.productCategory.vo.ProductCategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product/category")
public class ProductCategoryController {


    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("")
    public ModelAndView categoryPage(){
        List<ProductCategoryEntity> productCategorylist = productCategoryService.selectProductCategoryList();
        ModelAndView mav = new ModelAndView("category/category-form");
        mav.addObject("categoryList",productCategorylist);

        return mav;
    }


    @PostMapping("")
    public ModelAndView insertCategory(@ModelAttribute ProductCategoryVo params){
        productCategoryService.registrationProductCategory(params);
        return new ModelAndView("redirect:/product/category");
    }

}
