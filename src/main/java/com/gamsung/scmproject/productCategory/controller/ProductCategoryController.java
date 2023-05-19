package com.gamsung.scmproject.productCategory.controller;


import com.gamsung.scmproject.common.vo.ResultVo;
import com.gamsung.scmproject.productCategory.service.ProductCategoryService;
import com.gamsung.scmproject.productCategory.vo.ProductCategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@RequestMapping("/product/category")
public class ProductCategoryController {




    private ProductCategoryService productCategoryService;

    @GetMapping("/api/product/category/list")
    @ResponseBody
    public ResultVo<?> categoryPage(){
        List<ProductCategoryVo> productCategorylist = productCategoryService.selectProductCategoryList();
        ResultVo<List<ProductCategoryVo>> resultVo = new ResultVo<>();
        return resultVo;
    }

    @PostMapping("/api/product/category")
    @ResponseBody
    public ResultVo<?> insertCategory(@RequestBody ProductCategoryVo params){
        productCategoryService.registrationProductCategory(params);
        ResultVo<List<ProductCategoryVo>> resultVo = new ResultVo<>();
        return resultVo;
    }



//    @PostMapping("")
//    public ModelAndView insertCategory(@ModelAttribute ProductCategoryVo params){
//        productCategoryService.registrationProductCategory(params);
//        return new ModelAndView("redirect:/product/category");
//    }

}
