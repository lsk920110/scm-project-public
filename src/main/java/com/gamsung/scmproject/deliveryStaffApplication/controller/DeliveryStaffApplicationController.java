package com.gamsung.scmproject.deliveryStaffApplication.controller;

import com.gamsung.scmproject.common.constant.ErrorCode;
import com.gamsung.scmproject.common.constant.ModelObjectKey;
import com.gamsung.scmproject.common.controller.BaseController;
import com.gamsung.scmproject.common.vo.ResultVo;
import com.gamsung.scmproject.delivery.service.DeliveryService;
import com.gamsung.scmproject.delivery.service.DeliveryStaffService;
import com.gamsung.scmproject.delivery.vo.DeliveryInfoVo;
import com.gamsung.scmproject.delivery.vo.TransportCenterVo;
import com.gamsung.scmproject.deliveryStaffApplication.service.DeliveryStaffApplicationService;
import com.gamsung.scmproject.deliveryStaffApplication.vo.DeliveryStaffLoginVo;
import com.gamsung.scmproject.deliveryStaffApplication.vo.DeliveryStateUpdateParamVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DeliveryStaffApplicationController extends BaseController {

    @Autowired private DeliveryStaffApplicationService deliveryStaffApplicationService;
    @Autowired private DeliveryService deliveryService;
    @Autowired private DeliveryStaffService deliveryStaffService;

    @GetMapping("/deliveryStaffApplication/management")
    public String deliveryStaffApplication(Model model){

        menuBarInfo(model);
        List<TransportCenterVo> transportCenterVos = deliveryStaffService.tcInfoList();
        model.addAttribute(ModelObjectKey.TC_LIST,transportCenterVos);


        return "deliveryStaffApplication/deliveryStaffApplication-management-form";
    }






}
