package com.gamsung.scmproject.order.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderProductCordInfoVo {

    private Long id;
    private String productCord;
    private Long statementId;
    private int orderSeq;
    private int orderQuantity;
    private Long supplyPrice;
    private Long supplyPriceVat;
    private String modelCord;

}
