package com.gamsung.scmproject.order.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderInsertVo {

    private Long statementId;
    private Long orderId;
    private String failedReason;
    private Boolean success;
}
