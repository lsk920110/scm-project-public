package com.gamsung.scmproject.delivery.controller;

import com.gamsung.scmproject.common.constant.ErrorCode;
import com.gamsung.scmproject.common.controller.BaseController;
import com.gamsung.scmproject.common.vo.ResultVo;
import com.gamsung.scmproject.delivery.service.DeliveryStaffService;
import com.gamsung.scmproject.delivery.vo.DeliveryStaffInfoVo;
import com.gamsung.scmproject.delivery.vo.DeliveryStaffRegistrationVo;
import com.gamsung.scmproject.delivery.vo.TransportCenterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeliveryStaffController extends BaseController {

    @Autowired private DeliveryStaffService deliveryStaffService;

    @GetMapping("/deliveryStaff/management")
    public String deliveryStaffManagementForm(Model model){

        menuBarInfo(model);
        List<TransportCenterVo> list = deliveryStaffService.tcInfoList();
        model.addAttribute("tcList",list);
        List<DeliveryStaffInfoVo> deliveryStaffList = deliveryStaffService.selectDeliveryStaffList();
        model.addAttribute("deliveryStaffList",deliveryStaffList);
        return "deliveryStaff/deliveryStaff-management-form";

    }





    @PostMapping("/deliveryStaff/registration")
    @ResponseBody
    public ResultVo<?> deliveryStaffRegistration(@RequestBody DeliveryStaffRegistrationVo params){

        deliveryStaffService.insertDeliveryStaff(params);

        return makeResultVo(ErrorCode.SUCCESS);
    }


}
