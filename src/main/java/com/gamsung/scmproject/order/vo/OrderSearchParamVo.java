package com.gamsung.scmproject.order.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderSearchParamVo {
    private Long vendorId;

    /**
     * 1 : 주문번호
     * 2 : 판매번호
     * 3 : 납품번호
     * 4 : 고객명
     */
    private String searchCriteria;
    private String searchContent;
    private String orderCreateStartDt;
    private String orderCreateEndDt;
    private String orderState;
    private String modelCord;
    private String customerName;
}
