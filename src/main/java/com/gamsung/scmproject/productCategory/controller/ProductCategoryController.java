package com.gamsung.scmproject.productCategory.controller;


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




    @Autowired private ProductCategoryService productCategoryService;

    @Autowired private MenuBarService menuBarService;


    @GetMapping("/product/category")
    public String productCategoryManagementForm(Model model){
        menuBarInfo(model);
//        MenubarSideAndHeaderVo menubars = menuBarService.selectMenubarAll();
//
//        model.addAttribute(SessionKeys.SIDEBAR,menubars.getSidebarList());
//        model.addAttribute(SessionKeys.HEADER,menubars.getHeaderList());
        List<ProductCategoryVo> productCategoryList = productCategoryService.selectProductCategoryList();
        model.addAttribute("productCategoryList",productCategoryList);
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
