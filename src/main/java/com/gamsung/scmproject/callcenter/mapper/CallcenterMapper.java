package com.gamsung.scmproject.callcenter.mapper;

import com.gamsung.scmproject.callcenter.vo.HistoryInfoVo;
import com.gamsung.scmproject.callcenter.vo.OrderInfoWithCallHistoryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CallcenterMapper {
    OrderInfoWithCallHistoryVo selectOrderInfoWithCallHistory(Long vendorId, String criteria, String content);

    List<HistoryInfoVo> selectCallHistoryList(Long orderId);
}
