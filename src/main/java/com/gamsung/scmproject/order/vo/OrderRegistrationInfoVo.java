package com.gamsung.scmproject.order.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class OrderRegistrationInfoVo {
    private Long id;
    private Long vendorId;
    private String salesNo;
    private String deliveryReqDt;
    private String customerName;
    private String customerPhoneNumber;
    private String customerAddressFirst;
    private String customerAddressSecond;
    private String customerAddressThird;
    private String customerAddressDetail;
    private String remarks;
    private List<OrderProductCordVo> orderProductCordArray;

}
