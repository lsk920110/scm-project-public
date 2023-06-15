package com.gamsung.scmproject.salesInfo.vo;

import lombok.Data;

@Data
public class SalesProductCordVo {

    private Long id;
    private Long salesId;
    private Long statementId;
    private String productCord;
    private String modelCord;
    private int orderQuantity;
    private Long supplyPrice;
    private Long supplyPriceVat;
    private int orderSeq;
}
