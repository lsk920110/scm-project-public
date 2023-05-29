package com.gamsung.scmproject.productModel.controller;

import com.gamsung.scmproject.common.controller.BaseController;
import com.gamsung.scmproject.common.vo.ResultVo;
import com.gamsung.scmproject.productCategory.service.ProductCategoryService;
import com.gamsung.scmproject.productCategory.vo.ProductCategoryVo;
import com.gamsung.scmproject.productModel.service.ProductModelService;
import com.gamsung.scmproject.productModel.vo.ProductModelForListVo;
import com.gamsung.scmproject.productModel.vo.ProductModelVo;
import com.gamsung.scmproject.productModel.vo.ProductStatusVo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        List<ProductModelForListVo> list = productModelService.selectProductModelAll();
        mav.addObject("productModelList",list);
        List<ProductCategoryVo> productCategoryList = productCategoryService.selectProductCategoryList("1");
        mav.addObject("productCategoryList",productCategoryList);
        List<ProductStatusVo> productStatusList = productCategoryService.selectProductStatusList();
        mav.addObject("productStatusList",productStatusList);
        return mav;
    }

    @PostMapping("/product/model")
    public String productModelRegistration(Model model, HttpSession session, @ModelAttribute ProductModelVo params){
        sessionLoginInfo(session , params);
        productModelService.insertProductModel(params);

        return "redirect:/product/model/management";
    }

    @GetMapping("/api/product/model") @ResponseBody
    public ResultVo<?> apiProductModelList(
            @RequestParam Long productCategoryId
    ){
        List<ProductModelVo> productModelList
                = productModelService.selectProductModelByProductCategoryId(productCategoryId);
        ResultVo<List<ProductModelVo>> resultVo = new ResultVo<>();

        resultVo.setErrorCode("0000");
        resultVo.setErrorMessage("success");
        resultVo.setResult(productModelList);
        return resultVo;
    }





}
