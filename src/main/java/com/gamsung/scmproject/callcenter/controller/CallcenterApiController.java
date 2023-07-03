package com.gamsung.scmproject.callcenter.controller;

import com.gamsung.scmproject.callcenter.service.CallcenterService;
import com.gamsung.scmproject.callcenter.vo.CallcenterSearchResultVo;
import com.gamsung.scmproject.callcenter.vo.HistoryInfoVo;
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


    //특정 orderId를 기준으로 orderInfo + callHistory 불러오기



    //검색을 통해 주문리스트 불러오기
    @GetMapping("/search")
    public ResultVo<?> callcenterOrderInfoSearch(@RequestParam Long vendorId,
                                                 @RequestParam String criteria,
                                                 @RequestParam String content){

        List<CallcenterSearchResultVo> result = callcenterService.selectCallInfo(vendorId,criteria,content);

        return makeResultVo(ErrorCode.SUCCESS,result);
    }

    @GetMapping("/history")
    public ResultVo<?> callHistoryList(@RequestParam Long orderId){

        List<HistoryInfoVo> result = callcenterService.selectCallHistoryList(orderId);

        return makeResultVo(ErrorCode.SUCCESS , result);
    }

}
