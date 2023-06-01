package com.gamsung.scmproject.order.controller;

import com.gamsung.scmproject.common.controller.BaseController;
import com.gamsung.scmproject.common.vo.ResultVo;
import com.gamsung.scmproject.order.service.OrderService;
import com.gamsung.scmproject.order.vo.OrderInfoForListVo;
import com.gamsung.scmproject.order.vo.OrderRegistrationInfoVo;
import com.gamsung.scmproject.order.vo.OrderSearchParamVo;
import com.gamsung.scmproject.vendor.service.VendorService;
import com.gamsung.scmproject.vendor.vo.VendorWithMemberNameVo;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
public class OrderController extends BaseController {


    @Autowired private VendorService vendorService;

    @Autowired private OrderService orderService;



    @GetMapping("order/registration")
    public String orderRegistrationForm(Model model){
        menuBarInfo(model);
        List<VendorWithMemberNameVo> vendorList = vendorService.selectVendorList("1");
        model.addAttribute("vendorList",vendorList);
        return "order/order-registration-form";
    }

    @GetMapping("order/management")
    public String orderManagementForm(Model model){
        menuBarInfo(model);
        List<VendorWithMemberNameVo> vendorList = vendorService.selectVendorList("1");
        model.addAttribute("vendorList",vendorList);
        return "order/order-management-form";
    }

    @PostMapping("/api/order/registration")
    @ResponseBody
    public ResultVo<?> orderRegistration(
            @RequestBody OrderRegistrationInfoVo params,
            @RequestParam(value="callback" , required = false) String callback,
            HttpSession session

            ){
        log.info("params : {}",params.toString());
        sessionLoginInfo(session,params);

        orderService.statementRegistration(params);
        if(callback.equals("orderRegistration")){
            orderService.orderRegistration(params);
        }

        ResultVo<Object> resultVo = new ResultVo<>();
        resultVo.setErrorCode("0000");
        resultVo.setErrorMessage("success");
        return resultVo;
    }

    @PostMapping("/api/order/list")
    @ResponseBody
    public ResultVo<?> orderList(@RequestBody OrderSearchParamVo params){
        log.info("params : {}", params.toString());
        List<OrderInfoForListVo> list = orderService.selectOrderList(params);
        ResultVo<List<OrderInfoForListVo>> resultVo = new ResultVo<>();
        resultVo.setErrorMessage("success");
        resultVo.setErrorCode("0000");
        resultVo.setResult(list);
        return resultVo;
    }

}
