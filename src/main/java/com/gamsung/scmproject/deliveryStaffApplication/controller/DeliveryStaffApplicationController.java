package com.gamsung.scmproject.deliveryStaffApplication.controller;

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
//        deliveryStaffApplicationService.
        List<TransportCenterVo> transportCenterVos = deliveryStaffService.tcInfoList();
        model.addAttribute("tcList",transportCenterVos);


        return "deliveryStaffApplication/deliveryStaffApplication-management-form";
    }


    @PostMapping("/api/delivery/login")
    @ResponseBody
    public ResultVo<?> deliveryStaffLogin(@RequestBody DeliveryStaffLoginVo params){
        deliveryStaffApplicationService.deliveryStaffLogin(params);

        ResultVo<Object> resultVo = new ResultVo<>();
        resultVo.setErrorCode("0000");
        resultVo.setErrorMessage("success");

        return resultVo;
    }

    @GetMapping("/api/deliveryStaff/list")
    @ResponseBody
    public ResultVo<?> deliveryStaffList(@RequestParam String tc){

        List<DeliveryInfoVo> list = deliveryStaffService.selectDeliveryStaffListByTc(tc);
        return makeResultVo("0000",list);
    }

    

    @GetMapping("/api/delivery/list")
    @ResponseBody
    public ResultVo<?> deliveryListForStaff(@RequestParam String staffId){

        //특정기사에게 금일 할당된 배송 리스트를 불러온다.
        List<DeliveryInfoVo> list = deliveryStaffApplicationService.deliveryListByStaffId(staffId);

        ResultVo<List<DeliveryInfoVo>> resultVo = new ResultVo<>();
        return makeResultVo("0000",list);
    }

    @PostMapping("/api/update/delivery/state")
    @ResponseBody
    public ResultVo<?> updateDeliveryState(@RequestBody DeliveryStateUpdateParamVo params){

        //특정 고객 주문번호(배송번호)를 배송한후 결과를 전달하고 업데이트한다.
        deliveryStaffApplicationService.updateDeliveryState(params);

        return makeResultVo("0000");
    }





}
