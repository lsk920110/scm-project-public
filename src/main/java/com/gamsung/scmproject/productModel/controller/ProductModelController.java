package com.gamsung.scmproject.productModel.controller;

import com.gamsung.scmproject.common.controller.BaseController;
import com.gamsung.scmproject.productCategory.service.ProductCategoryService;
import com.gamsung.scmproject.productCategory.vo.ProductCategoryVo;
import com.gamsung.scmproject.productModel.service.ProductModelService;
import com.gamsung.scmproject.productModel.vo.ProductModelVo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class ProductModelController extends BaseController {

    @Autowired private ProductModelService productModelService;

    @Autowired private ProductCategoryService productCategoryService;

    @GetMapping("/product/model/management")
    public ModelAndView productModelForm(){
        ModelAndView mav = new ModelAndView("productModel/productModel-form");
        menuBarInfo(mav);
//        List<ProductModelVo> list = productModelService.selectProductModelAll();
//        mav.addObject("productModelList",list);
        List<ProductCategoryVo> productCategoryList = productCategoryService.selectProductCategoryList();
        mav.addObject("productCategoryList",productCategoryList);
        return mav;
    }

    @PostMapping("/product/model")
    public String productModelRegistration(Model model, HttpSession session, @ModelAttribute ProductModelVo params){
        sessionLoginInfo(session , params);
        productModelService.insertProductModel(params);

        return "redirect:/product/model/management";
    }





}
