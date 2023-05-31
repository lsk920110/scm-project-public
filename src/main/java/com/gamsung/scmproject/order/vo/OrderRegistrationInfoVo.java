package com.gamsung.scmproject.order.vo;

import com.gamsung.scmproject.member.vo.AuthIf;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class OrderRegistrationInfoVo implements AuthIf {
    private Long id;
    private Long vendorId;
    private String salesNo;
    private String deliveryReqDt;
    private String customerName;
    private String customerPhoneNumber;
    private String customerAddressFirst;
    private String customerAddressSecond;
    private String customerAddressThird;
    private String customerAddressDetail;
    private String remarks;
    private String state;
    private List<OrderProductCordVo> orderProductCordArray;

    private Long regMemberId;

    @Override
    public Long getLoginId() {
        return this.regMemberId;
    }

    @Override
    public void setLoginId(Long loginId) {
        this.regMemberId = loginId;
    }
}
