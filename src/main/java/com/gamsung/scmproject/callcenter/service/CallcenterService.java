package com.gamsung.scmproject.callcenter.service;

import com.gamsung.scmproject.callcenter.vo.CallcenterSearchResultVo;
import com.gamsung.scmproject.callcenter.vo.HistoryInfoVo;

import java.util.List;

public interface CallcenterService {

    List<CallcenterSearchResultVo> selectCallInfo(Long vendorId, String criteria, String content);

    List<HistoryInfoVo> selectCallHistoryList(Long orderId);
}
