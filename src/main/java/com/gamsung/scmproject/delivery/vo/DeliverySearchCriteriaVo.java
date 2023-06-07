package com.gamsung.scmproject.delivery.vo;

import lombok.Data;

@Data
public class DeliverySearchCriteriaVo {

    private Long vendorId;
    private Long deliveryId;
    private String expectedDeliveryDt_start;
    private String expectedDeliveryDt_end;
    private String deliveryStaffName;
    private String modelCord;
    private String customerName;

}
