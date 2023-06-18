package com.gamsung.scmproject.salesInfo.controller;

import com.gamsung.scmproject.common.constant.ErrorCode;
import com.gamsung.scmproject.common.controller.BaseController;
import com.gamsung.scmproject.common.vo.ResultVo;
import com.gamsung.scmproject.salesInfo.service.SalesInfoService;
import com.gamsung.scmproject.salesInfo.vo.SalesInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class SalesInfoController extends BaseController {


    @Autowired private SalesInfoService salesInfoService;


    @GetMapping("/salesInfo/management")
    public ModelAndView salesInfoManagement(){
        ModelAndView modelAndView = new ModelAndView("salesInfo/sales-management-form");
        menuBarInfo(modelAndView);
        vendorList(modelAndView);
        return modelAndView;
    }

    @GetMapping("/api/salesInfo/batch/test")
    @ResponseBody
    public ResultVo<?> batchTest(){
        List<SalesInfoVo> list = salesInfoService.batchSalesInfo();

        return makeResultVo(ErrorCode.SUCCESS,list);
    }


    @GetMapping("/api/salesInfo")
    @ResponseBody
    public ResultVo<?> salesInfo(@RequestParam Long vendorId,@RequestParam String startDt, @RequestParam String endDt){
        log.info("vendorId : {} , startDt : {} , endDt : {}",vendorId,startDt,endDt);
        List<SalesInfoVo> list = salesInfoService.selectInfo(vendorId,startDt,endDt);

        return makeResultVo(ErrorCode.SUCCESS,list);
    }


}
