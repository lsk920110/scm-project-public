package com.gamsung.scmproject.salesInfo.vo;

import lombok.Data;

@Data
public class SalesInfoFromSalesInfoVo {
    private Long id;
    private Long deliveryId;
    private Long orderId;
    private Long statementId;
    private String tc;
    private Long vendorId;
    private String vendorName;
    private String salesNo;
    private String orderRegDt;
    private String deliveryCompletionDt;
    private String salesRegDt;
    private String customerName;
    private String productCord;
    private String modelCord;
    private int orderQuantity;
    private Long supplyPrice;
    private Long supplyPriceVat;
    private int orderSeq;
}
