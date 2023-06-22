package com.gamsung.scmproject.callcenter.service;

import com.gamsung.scmproject.callcenter.vo.OrderInfoWithCallHistoryVo;

import java.util.List;

public interface CallcenterService {
    OrderInfoWithCallHistoryVo selectOrderInfoWithCallHistory(Long vendorId, String criteria, String content);
}
