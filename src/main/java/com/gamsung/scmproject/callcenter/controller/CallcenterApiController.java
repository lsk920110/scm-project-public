package com.gamsung.scmproject.callcenter.controller;

import com.gamsung.scmproject.callcenter.service.CallcenterService;
import com.gamsung.scmproject.callcenter.vo.OrderInfoWithCallHistoryVo;
import com.gamsung.scmproject.common.constant.ErrorCode;
import com.gamsung.scmproject.common.controller.BaseController;
import com.gamsung.scmproject.common.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/callcenter")
public class CallcenterApiController extends BaseController {

    @Autowired private CallcenterService callcenterService;

    @GetMapping("/search")
    public ResultVo<?> callcenterOrderInfoSearch(@RequestParam Long vendorId,
                                                 @RequestParam String criteria,
                                                 @RequestParam String content){

        OrderInfoWithCallHistoryVo result = callcenterService.selectOrderInfoWithCallHistory(vendorId,criteria,content);

        return makeResultVo(ErrorCode.SUCCESS,result);
    }


}
