package com.gamsung.scmproject.delivery.controller;

import com.gamsung.scmproject.common.constant.ErrorCode;
import com.gamsung.scmproject.common.controller.BaseController;
import com.gamsung.scmproject.common.vo.ResultVo;
import com.gamsung.scmproject.delivery.service.DeliveryService;
import com.gamsung.scmproject.delivery.vo.DeliveryInfoVo;
import com.gamsung.scmproject.delivery.vo.DeliverySearchCriteriaVo;
import com.gamsung.scmproject.vendor.service.VendorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class DeliveryApiController extends BaseController {

    public static String[] DELIVERY_API_PATH = {
            "/deliveryStaff/management",
            "/deliveryStaff/registration",
            "/deliveryStaff/management",
    };

    @Autowired
    private DeliveryService deliveryService;


    @GetMapping("/api/batch/delivery/test")
    public ResultVo<?> assignDeliveryInfo(){

        int successRows = deliveryService.batchAssignDelivery();

        return makeResultVo(ErrorCode.SUCCESS,successRows);
    }

    @PostMapping("/api/delivery/list/search")
    public ResultVo<?> deliveryListSearch(@RequestBody DeliverySearchCriteriaVo params){
        log.info("params : {}",params.toString());
        List<DeliveryInfoVo> list =deliveryService.selectDeliveryList(params);

        return makeResultVo(ErrorCode.SUCCESS,list);
    }



}
