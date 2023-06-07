package com.gamsung.scmproject.delivery.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DeliveryAssignVo {

    //order정보
    private Long id;
    private String orderState;
    private String state;
    private String deliveryReqDt;
    private Long statementId;
    //statement 정보
    private String customerAddressFirst;

    //delivery정보

    //납품번호
    private Long deliveryId;
    private String tc;
    private String expectedDeliveryDt;
    private String shippingDt;
    private String deliveryCompletionDt;
    private String deliveryState;
    private Long deliveryStaffId;

}
