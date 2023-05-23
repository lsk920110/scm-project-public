package com.gamsung.scmproject.vendor.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class VendorWithMemberNameVo {
    private Long id;
    private String vendorName;
    private String businessRegNum;
    private String contractStartDt;
    private String contractEndDt;
    private String state;
    private Long regMemberId;
    private String regDt;
    private Long loginId;
    private String name;


}
