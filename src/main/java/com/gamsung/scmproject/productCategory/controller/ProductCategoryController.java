package com.gamsung.scmproject.productCategory.controller;


import com.gamsung.scmproject.common.constant.ModelObjectKey;
import com.gamsung.scmproject.common.constant.SessionKeys;
import com.gamsung.scmproject.common.controller.BaseController;
import com.gamsung.scmproject.common.vo.ResultVo;
import com.gamsung.scmproject.menubar.service.MenuBarService;
import com.gamsung.scmproject.menubar.vo.MenubarInfoVo;
import com.gamsung.scmproject.menubar.vo.MenubarSideAndHeaderVo;
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
public class ProductCategoryController extends BaseController {

    public static final String[] PRODUCT_CATEGORY_PATH = {
            "/productCord/management",
            "/productCord/registration",
            "/productCord",
            "/api/productModelInfo",
    };


    @Autowired private ProductCategoryService productCategoryService;

    @Autowired private MenuBarService menuBarService;


    @GetMapping("/product/category")
    public String productCategoryManagementForm(Model model){
        menuBarInfo(model);
        List<ProductCategoryVo> productCategoryList = productCategoryService.selectProductCategoryList(null);
        model.addAttribute(ModelObjectKey.PRODUCT_CATEGORY_LIST,productCategoryList);
        return "category/category-form";
    }

    @PostMapping("/product/category")
    public String productCategoryRegistration(@ModelAttribute ProductCategoryVo params){
        params.setMemberId(100000);
        productCategoryService.registrationProductCategory(params);
        return "redirect:/product/category";
    }

    @GetMapping("/api/product/category/list")
    @ResponseBody
    public ResultVo<?> categoryPage(){
        List<ProductCategoryVo> productCategorylist = productCategoryService.selectProductCategoryList(null);
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


}
