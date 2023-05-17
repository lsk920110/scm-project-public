package com.gamsung.scmproject.productModel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product/model")
public class ProductModelController {



    @GetMapping("")
    public ModelAndView productModelForm(){

        ModelAndView mav = new ModelAndView("productModel/productModel-form");

        return null;
    }





}
