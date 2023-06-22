package com.gamsung.scmproject.callcenter.vo;

import lombok.Data;

import java.util.List;

@Data
public class OrderInfoWithCallHistoryVo {

    private Long vendorId;
    private Long orderId;
    private String salesNo;
    private String reqDt;
    private String customerName;
    private String customerPhoneNum;
    private String customerAddressFirst;
    private String customerAddressSecond;
    private String customerAddressThird;
    private String customerAddressDetail;
    private String remarks;
    private List<HistoryInfoVo> historyList;


}
