package com.gamsung.scmproject.callcenter.mapper;

import com.gamsung.scmproject.callcenter.vo.CallcenterOrderInfoVo;
import com.gamsung.scmproject.callcenter.vo.CallcenterSearchResultVo;
import com.gamsung.scmproject.callcenter.vo.HistoryInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@Mapper
public interface CallcenterMapper {

//    List<HistoryInfoVo> selectCallHistoryList(Long orderId);

    List<CallcenterSearchResultVo> selectOrderInfoList(@Qualifier("vendorId") Long vendorId, @Qualifier("criteria") String criteria, @Qualifier("content") String content);

    List<HistoryInfoVo> selectCallHistoryList(Long orderId);

    CallcenterOrderInfoVo selectOrderInfo(@Qualifier("orderId") Long orderId);
}
