package com.gamsung.scmproject.order.controller;

import com.gamsung.scmproject.common.constant.ErrorCode;
import com.gamsung.scmproject.common.constant.ModelObjectKey;
import com.gamsung.scmproject.common.controller.BaseController;
import com.gamsung.scmproject.common.vo.ResultVo;
import com.gamsung.scmproject.order.service.OrderService;
import com.gamsung.scmproject.order.vo.*;
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
        vendorList(model);
        List<String> deliveryAreaList = orderService.deliveryAreaList();
        model.addAttribute(ModelObjectKey.DELIVERY_AREA_LIST,deliveryAreaList);
        return "order/order-registration-form";
    }

    @GetMapping("order/management")
    public String orderManagementForm(Model model){
        menuBarInfo(model);
        vendorList(model);
        List<String> deliveryAreaList = orderService.deliveryAreaList();
        model.addAttribute(ModelObjectKey.DELIVERY_AREA_LIST,deliveryAreaList);
        return "order/order-management-form";
    }

    @GetMapping("order/update")
    public String orderManagementUpdateForm(Model model , @RequestParam Long statementId){
        menuBarInfo(model);
        StatementInfoVo statementInfo = orderService.orderInfoByStatementId(statementId);
        model.addAttribute(ModelObjectKey.STATEMENT,statementInfo);
        List<String> deliveryAreaList = orderService.deliveryAreaList();
        model.addAttribute(ModelObjectKey.DELIVERY_AREA_LIST,deliveryAreaList);
        return "order/order-registration-update-form";
    }

    @PostMapping("/api/statement/insert")
    @ResponseBody
    public ResultVo<?> orderRegistration(
            @RequestBody OrderRegistrationInfoVo params,
//            @RequestParam(value="callback" , required = false) String callback,
            HttpSession session
            ){
        log.info("params : {}",params.toString());
        sessionLoginInfo(session,params);

        Long statementId = orderService.statementRegistration(params);

        return makeResultVo(ErrorCode.SUCCESS,statementId);
    }

    @PostMapping("/api/statement/update")
    @ResponseBody
    public ResultVo<?> updateStatement(
            @RequestBody OrderRegistrationInfoVo params,
//            @RequestParam(value="callback" , required = false) String callback,
            HttpSession session
    ){
        log.info("params : {}",params.toString());
        orderService.updateStatement(params);
        return makeResultVo(ErrorCode.SUCCESS);
    }


    @PostMapping("/api/order/insert")
    @ResponseBody
    public ResultVo<?> insertOrder(@RequestBody StatementListParamVo params){
        List<OrderInsertVo> orderInsertVos = orderService.insertOrderList(params.getStatementIdList());
        return makeResultVo(ErrorCode.SUCCESS,orderInsertVos);

    }



    @PostMapping("/api/order/list")
    @ResponseBody
    public ResultVo<?> orderList(@RequestBody OrderSearchParamVo params){
        log.info("params : {}", params.toString());
        List<OrderInfoForListVo> list = orderService.selectOrderList(params);
        return makeResultVo(ErrorCode.SUCCESS,list);

    }

    @DeleteMapping("/api/delete/statement")
    @ResponseBody
    public ResultVo<?> statementDelete(@RequestBody StatementListParamVo statementIdList){
        orderService.statementListDelete(statementIdList.getStatementIdList());
        return makeResultVo(ErrorCode.SUCCESS,"삭제완료");
    }

    @PostMapping("/api/delete/order")
    @ResponseBody
    public ResultVo<?> orderDelete(@RequestBody OrderIdListVo orderIdListVo){
        orderService.orderListDelete(orderIdListVo.getOrderIdList());
        return makeResultVo(ErrorCode.SUCCESS,"삭제완료");

    }



}
