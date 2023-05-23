package com.gamsung.scmproject.vendor.vo;

import com.gamsung.scmproject.member.vo.AuthIf;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class VendorVo implements AuthIf {

    private Long id;
    private String vendorName;
    private String businessRegNum;
    private String contractStartDt;
    private String contractEndDt;
    private String state;
    private Long regMemberId;
    private String regDt;
    private Long loginId;


    @Override
    public Long getLoginId() {
        return this.loginId;
    }

    @Override
    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }
}
