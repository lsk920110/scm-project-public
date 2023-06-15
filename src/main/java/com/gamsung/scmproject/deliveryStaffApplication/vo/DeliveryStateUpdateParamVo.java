package com.gamsung.scmproject.deliveryStaffApplication.vo;

import lombok.Data;

@Data
public class DeliveryStateUpdateParamVo {

    private Long deliveryStaffId;
    private Long deliveryId;
    private String reqState;
}
