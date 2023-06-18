package com.gamsung.scmproject.productCord.controller;

import com.gamsung.scmproject.common.constant.ErrorCode;
import com.gamsung.scmproject.common.constant.ModelObjectKey;
import com.gamsung.scmproject.common.controller.BaseController;
import com.gamsung.scmproject.common.vo.ResultVo;
import com.gamsung.scmproject.productCategory.service.ProductCategoryService;
import com.gamsung.scmproject.productCategory.vo.ProductCategoryVo;
import com.gamsung.scmproject.productCord.service.ProductCordService;
import com.gamsung.scmproject.productCord.vo.ProductCordVo;
import com.gamsung.scmproject.productCord.vo.ProductCordVoForList;
import com.gamsung.scmproject.productCord.vo.ProductCordWithVendorAndProductModelVo;
import com.gamsung.scmproject.productModel.vo.ProductModelVo;
import com.gamsung.scmproject.vendor.service.VendorService;
import com.gamsung.scmproject.vendor.vo.VendorWithMemberNameVo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductCordController extends BaseController {


    @Autowired private VendorService vendorService;
    @Autowired private ProductCategoryService productCategoryService;

    @Autowired private ProductCordService productCordService;


    @GetMapping("/productCord/management")
    public String productCordManagement(Model model){
        menuBarInfo(model);
        vendorList(model);
        List<ProductCategoryVo> productCategoryList = productCategoryService.selectProductCategoryList("1");
        model.addAttribute(ModelObjectKey.PRODUCT_CATEGORY_LIST,productCategoryList);
        List<ProductCordVoForList> productCordList = productCordService.productCordList(null);
        model.addAttribute(ModelObjectKey.PRODUCT_CORD_LIST,productCordList);
        return "productCord/productCord-form";
    }

    @GetMapping("/productCord/registration")
    public String productCordRegistrationForm(Model model){

        return "";
    }

    @PostMapping("/productCord")
    public String productCordRegistration(
            Model model ,HttpSession session,ProductCordVo params)throws Exception{
        sessionLoginInfo(session,params);
        productCordService.insertProductCord(params);

        return "redirect:/productCord/management";
    }

    @GetMapping("/api/productModelInfo")
    @ResponseBody
    public ResultVo<?> productModelInfoByVendorIdAndProductCord(
            @RequestParam("productCord") String productCord, @RequestParam("vendorId") Long vendorId
    ){
        ProductCordWithVendorAndProductModelVo productModelInfo = productCordService.selectProductModelInfoByVendorIdAndProductCord(productCord,vendorId);
        return makeResultVo(ErrorCode.SUCCESS,productModelInfo);
    }
}
