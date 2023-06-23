package com.gamsung.scmproject.callcenter.mapper;

import com.gamsung.scmproject.callcenter.vo.HistoryInfoVo;
import com.gamsung.scmproject.callcenter.vo.OrderInfoWithCallHistoryVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@Mapper
public interface CallcenterMapper {
    OrderInfoWithCallHistoryVo selectOrderInfoWithCallHistory(@Qualifier("vendorId") Long vendorId,
                                                              @Qualifier("criteria") String criteria,
                                                              @Qualifier("content") String content);

    List<HistoryInfoVo> selectCallHistoryList(Long orderId);
}
