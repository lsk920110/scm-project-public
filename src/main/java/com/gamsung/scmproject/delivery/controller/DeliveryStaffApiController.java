package com.gamsung.scmproject.delivery.controller;

import com.gamsung.scmproject.common.constant.ErrorCode;
import com.gamsung.scmproject.common.constant.ModelObjectKey;
import com.gamsung.scmproject.common.controller.BaseController;
import com.gamsung.scmproject.common.vo.ResultVo;
import com.gamsung.scmproject.delivery.service.DeliveryStaffService;
import com.gamsung.scmproject.delivery.vo.DeliveryStaffInfoVo;
import com.gamsung.scmproject.delivery.vo.DeliveryStaffRegistrationVo;
import com.gamsung.scmproject.delivery.vo.TransportCenterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeliveryStaffApiController extends BaseController {

    @Autowired private DeliveryStaffService deliveryStaffService;


    @PostMapping("/deliveryStaff/registration")
    public ResultVo<?> deliveryStaffRegistration(@RequestBody DeliveryStaffRegistrationVo params){

        deliveryStaffService.insertDeliveryStaff(params);

        return makeResultVo(ErrorCode.SUCCESS);
    }


}
