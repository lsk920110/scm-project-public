package com.gamsung.scmproject.callcenter.service.impl;

import com.gamsung.scmproject.callcenter.vo.CallcenterOrderInfoVo;
import com.gamsung.scmproject.callcenter.vo.CallcenterSearchResultVo;
import com.gamsung.scmproject.callcenter.mapper.CallcenterMapper;
import com.gamsung.scmproject.callcenter.service.CallcenterService;
import com.gamsung.scmproject.callcenter.vo.HistoryInfoVo;
import com.gamsung.scmproject.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CallcenterServiceImpl implements CallcenterService {

    @Autowired private CallcenterMapper callcenterMapper;

    @Autowired private OrderService orderService;

    @Override
    public List<CallcenterSearchResultVo> selectCallInfo(Long vendorId, String criteria, String content) {
        return callcenterMapper.selectOrderInfoList(vendorId,criteria,content);
    }



    @Override
    public List<HistoryInfoVo> selectCallHistoryList(Long orderId) {
        List<HistoryInfoVo> list = callcenterMapper.selectCallHistoryList(orderId);
//        CallcenterOrderInfoVo orderInfo = callcenterMapper.selectOrderInfo(orderId);
        CallcenterOrderInfoVo orderInfo = callcenterMapper.selectOrderInfo(orderId);
        return list;

    }



}
