package com.gamsung.scmproject.delivery.vo;

import lombok.Data;

@Data
public class DeliveryStaffInfoVo {
    private Long id;

    private String tc;
    private String deliveryArea;
    private String staffName;
    private String staffPhoneNum;
    private String state;
}
