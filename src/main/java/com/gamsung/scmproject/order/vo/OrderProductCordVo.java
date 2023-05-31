package com.gamsung.scmproject.order.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderProductCordVo {


    private Long id;
    private Long statementId;
    private int orderSeq;
    private String productCord;
    private String modelCord;
    private String orderQuantity;

}
