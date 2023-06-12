package com.gamsung.scmproject.deliveryStaffApplication.controller;

import com.gamsung.scmproject.common.controller.BaseController;
import com.gamsung.scmproject.common.vo.ResultVo;
import com.gamsung.scmproject.deliveryStaffApplication.service.DeliveryStaffApplicationService;
import com.gamsung.scmproject.deliveryStaffApplication.vo.DeliveryListCallByStaffIdParamVo;
import com.gamsung.scmproject.deliveryStaffApplication.vo.DeliveryStaffLoginVo;
import com.gamsung.scmproject.deliveryStaffApplication.vo.DeliveryStateUpdateParamVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeliveryStaffApplicationController extends BaseController {

    @Autowired private DeliveryStaffApplicationService deliveryStaffApplicationService;


    @GetMapping("/deliveryStaffApplication/management")
    public String deliveryStaffApplication(Model model){

        menuBarInfo(model);
//        deliveryStaffApplicationService.


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


    @GetMapping("/api/delivery/list/forStaff")
    @ResponseBody
    public ResultVo<?> deliveryListForStaff(@RequestBody DeliveryListCallByStaffIdParamVo params){

        //특정기사에게 금일 할당된 배송 리스트를 불러온다.
        deliveryStaffApplicationService.deliveryListByStaffId(params);


        return null;
    }

    @PostMapping("/api/delivery/state")
    @ResponseBody
    public ResultVo<?> deliveryStateUpdate(@RequestBody DeliveryStateUpdateParamVo params){

        //특정 고객 주문번호(배송번호)를 배송한후 결과를 전달하고 업데이트한다.
        deliveryStaffApplicationService.deliveryStateUpdate(params);

        return null;
    }



}
