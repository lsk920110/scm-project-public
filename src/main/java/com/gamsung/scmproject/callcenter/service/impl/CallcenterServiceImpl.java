package com.gamsung.scmproject.callcenter.service.impl;

import com.gamsung.scmproject.callcenter.mapper.CallcenterMapper;
import com.gamsung.scmproject.callcenter.service.CallcenterService;
import com.gamsung.scmproject.callcenter.vo.HistoryInfoVo;
import com.gamsung.scmproject.callcenter.vo.OrderInfoWithCallHistoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CallcenterServiceImpl implements CallcenterService {

    @Autowired private CallcenterMapper callcenterMapper;

    @Override
    public OrderInfoWithCallHistoryVo selectOrderInfoWithCallHistory(Long vendorId, String criteria, String content) {
        OrderInfoWithCallHistoryVo result = callcenterMapper.selectOrderInfoWithCallHistory(vendorId,criteria,content);
        List<HistoryInfoVo> historyInfoVo = callcenterMapper.selectCallHistoryList(result.getOrderId());
        result.setHistoryList(historyInfoVo);
        return result;
    }
}
