package com.gamsung.scmproject.productCord.vo;

import com.gamsung.scmproject.member.vo.AuthIf;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ProductCordVo implements AuthIf {
    private Long id;
    private Long vendorId;
    private Long productModelId;
    private String productCord;
    private Long supplyPrice;
    private Long supplyPriceVat;
    private LocalDateTime regDt;
    private String state;
    private Long regMemberId;

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
