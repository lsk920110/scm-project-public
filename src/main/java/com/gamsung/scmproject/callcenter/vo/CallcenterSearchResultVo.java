package com.gamsung.scmproject.callcenter.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CallcenterSearchResultVo {
    private String vendorName;
    private Long orderId;
    private Long deliveryId;
    private String salesNo;
    private String customerName;
    private String customerPhoneNumber;
    private String customerAddressFirst;
    private String state;
}
