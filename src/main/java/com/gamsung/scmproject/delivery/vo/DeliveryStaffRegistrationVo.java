package com.gamsung.scmproject.delivery.vo;

import lombok.Data;

@Data
public class DeliveryStaffRegistrationVo {

    private String tc;
    private String staffName;
    private String staffPhoneNum;
    private String state;

    //계약관련한것은 하지말자...

//    private String contractState;
//    private String contractStartDt;
//    private String contractEndDt;
//    private String individualBusinessRegNum;



}
