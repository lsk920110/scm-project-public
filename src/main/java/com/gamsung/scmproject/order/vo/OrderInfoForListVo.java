package com.gamsung.scmproject.order.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class OrderInfoForListVo {

    private Long statementId;
    private String salesNo;
    private String customerName;
    private String customerPhoneNumber;
    private String deliveryReqDt;
    private String statementState;
    private String orderRegDt;
    private Long orderId;
    private String orderState;
    private String tc;
    private String expectedDeliveryDt;
    private String deliveryCompletionDt;
    private Long deliveryId;
    private List<OrderProductCordInfoVo> productList;

}
