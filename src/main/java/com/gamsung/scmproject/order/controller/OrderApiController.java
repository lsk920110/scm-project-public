package com.gamsung.scmproject.order.controller;

import com.gamsung.scmproject.common.constant.ErrorCode;
import com.gamsung.scmproject.common.constant.ModelObjectKey;
import com.gamsung.scmproject.common.controller.BaseController;
import com.gamsung.scmproject.common.vo.ResultVo;
import com.gamsung.scmproject.order.service.OrderService;
import com.gamsung.scmproject.order.vo.*;
import com.gamsung.scmproject.vendor.service.VendorService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class OrderApiController extends BaseController {


    @Autowired private VendorService vendorService;

    @Autowired private OrderService orderService;




    @GetMapping("/api/order/update")
    public ResultVo<?> orderManagementUpdateForm(Model model , @RequestParam Long statementId){
        StatementInfoVo statementInfo = orderService.orderInfoByStatementId(statementId);
        return makeResultVo(ErrorCode.SUCCESS,statementInfo);
    }

    @PostMapping("/api/statement/insert")
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
    public ResultVo<?> insertOrder(@RequestBody StatementListParamVo params){
        List<OrderInsertVo> orderInsertVos = orderService.insertOrderList(params.getStatementIdList());
        return makeResultVo(ErrorCode.SUCCESS,orderInsertVos);

    }



    @PostMapping("/api/order/list")
    public ResultVo<?> orderList(@RequestBody OrderSearchParamVo params){
        log.info("params : {}", params.toString());
        List<OrderInfoForListVo> list = orderService.selectOrderList(params);
        return makeResultVo(ErrorCode.SUCCESS,list);

    }

    @DeleteMapping("/api/delete/statement")
    public ResultVo<?> statementDelete(@RequestBody StatementListParamVo statementIdList){
        orderService.statementListDelete(statementIdList.getStatementIdList());
        return makeResultVo(ErrorCode.SUCCESS,"삭제완료");
    }

    @PostMapping("/api/delete/order")
    public ResultVo<?> orderDelete(@RequestBody OrderIdListVo orderIdListVo){
        orderService.orderListDelete(orderIdListVo.getOrderIdList());
        return makeResultVo(ErrorCode.SUCCESS,"삭제완료");
    }



}
