package com.gamsung.scmproject.delivery.controller;

import com.gamsung.scmproject.common.constant.ErrorCode;
import com.gamsung.scmproject.common.constant.State;
import com.gamsung.scmproject.common.controller.BaseController;
import com.gamsung.scmproject.common.vo.ResultVo;
import com.gamsung.scmproject.delivery.service.DeliveryService;
import com.gamsung.scmproject.delivery.vo.DeliveryInfoVo;
import com.gamsung.scmproject.delivery.vo.DeliverySearchCriteriaVo;
import com.gamsung.scmproject.vendor.service.VendorService;
import com.gamsung.scmproject.vendor.vo.VendorWithMemberNameVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.transform.Result;
import java.util.List;

@Slf4j
@Controller
public class DeliveryController extends BaseController {

    @GetMapping("/delivery/management")
    public String deliveryForm(Model model){
        menuBarInfo(model);
        vendorList(model);

        return "delivery/delivery-management-form";
    }



}
