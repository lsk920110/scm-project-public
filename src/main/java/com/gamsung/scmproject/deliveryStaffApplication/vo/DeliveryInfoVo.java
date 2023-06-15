package com.gamsung.scmproject.deliveryStaffApplication.vo;

import lombok.Data;

@Data
public class DeliveryInfoVo {
    private Long deliveryId;
    private String expectedDeliveryDt;
    private String deliveryCompletionDt;
    private String deliveryState;
    private String customerName;

}
