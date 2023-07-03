package com.gamsung.scmproject.callcenter.vo;

import lombok.Data;

@Data
public class CallcenterOrderInfoVo {

    private String vendorName;
    private String salesNo;
    private String deliveryReqDt;
    private String customerName;
    private String customerPhoneNumber;
    private String customerAddressFirst;
    private String customerAddressSecond;
    private String customerAddressDetail;
    private String remarks;
    private String expectedDeliveryDt;
    private String deliveryCompletionDt;
    private String tc;
    private String staffName;
    private String staffPhoneNum;



}
