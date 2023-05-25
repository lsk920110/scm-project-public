package com.gamsung.scmproject.productCord.controller;

import com.gamsung.scmproject.common.controller.BaseController;
import com.gamsung.scmproject.productCategory.service.ProductCategoryService;
import com.gamsung.scmproject.productCategory.vo.ProductCategoryVo;
import com.gamsung.scmproject.vendor.service.VendorService;
import com.gamsung.scmproject.vendor.vo.VendorWithMemberNameVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductCordController extends BaseController {


    @Autowired private VendorService vendorService;
    @Autowired private ProductCategoryService productCategoryService;
    @GetMapping("/productCord/management")
    public String productCordManagement(Model model){
        menuBarInfo(model);
        List<VendorWithMemberNameVo> vendorList = vendorService.selectVendorList("1");
        model.addAttribute("vendorList",vendorList);
        List<ProductCategoryVo> productCategoryList = productCategoryService.selectProductCategoryList("1");
        model.addAttribute("productCategoryList",productCategoryList);

        return "productCord/productCord-form";
    }


}
