package com.gamsung.scmproject.salesInfo.controller;

import com.gamsung.scmproject.common.controller.BaseController;
import com.gamsung.scmproject.common.vo.ResultVo;
import com.gamsung.scmproject.salesInfo.service.SalesInfoService;
import com.gamsung.scmproject.salesInfo.vo.SalesInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SalesInfoController extends BaseController {


    @Autowired private SalesInfoService salesInfoService;


    @GetMapping("/salesInfo/management")
    public ModelAndView salesInfoManagement(){
        ModelAndView modelAndView = new ModelAndView("salesInfo/sales-management-form");
        menuBarInfo(modelAndView);

        return modelAndView;
    }

    @GetMapping("/api/salesInfo/batch/test")
    @ResponseBody
    public ResultVo<?> batchTest(){
        List<SalesInfoVo> list = salesInfoService.batchSalesInfo();

        return makeResultVo("0000",list);
    }



}
