package com.gamsung.scmproject.salesInfo.service;

import com.gamsung.scmproject.salesInfo.vo.SalesInfoVo;

import java.util.List;

public interface SalesInfoService {
    List<SalesInfoVo> batchSalesInfo();

    List<SalesInfoVo> selectInfo(Long vendorId, String startDt, String endDt);
}
