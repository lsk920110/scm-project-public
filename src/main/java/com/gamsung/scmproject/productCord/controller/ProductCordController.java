package com.gamsung.scmproject.productCord.controller;

import com.gamsung.scmproject.common.controller.BaseController;
import com.gamsung.scmproject.productCategory.service.ProductCategoryService;
import com.gamsung.scmproject.productCategory.vo.ProductCategoryVo;
import com.gamsung.scmproject.productCord.service.ProductCordService;
import com.gamsung.scmproject.productCord.vo.ProductCordVo;
import com.gamsung.scmproject.productCord.vo.ProductCordVoForList;
import com.gamsung.scmproject.vendor.service.VendorService;
import com.gamsung.scmproject.vendor.vo.VendorWithMemberNameVo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductCordController extends BaseController {


    @Autowired private VendorService vendorService;
    @Autowired private ProductCategoryService productCategoryService;

    @Autowired private ProductCordService productCordService;


    @GetMapping("/productCord/management")
    public String productCordManagement(Model model){
        menuBarInfo(model);
        List<VendorWithMemberNameVo> vendorList = vendorService.selectVendorList("1");
        model.addAttribute("vendorList",vendorList);
        List<ProductCategoryVo> productCategoryList = productCategoryService.selectProductCategoryList("1");
        model.addAttribute("productCategoryList",productCategoryList);
        List<ProductCordVoForList> productCordList = productCordService.productCordList(null);
        model.addAttribute("productCordList",productCordList);
        return "productCord/productCord-form";
    }

    @PostMapping("/productCord")
    public String productCordRegistration(
            Model model ,HttpSession session,ProductCordVo params)throws Exception{
        sessionLoginInfo(session,params);
        productCordService.insertProductCord(params);

        return "redirect:/productCord/management";
    }


}
