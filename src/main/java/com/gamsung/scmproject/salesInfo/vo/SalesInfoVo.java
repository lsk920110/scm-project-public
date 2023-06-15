package com.gamsung.scmproject.salesInfo.vo;

import com.gamsung.scmproject.order.vo.OrderProductCordInfoVo;
import lombok.Data;

import java.util.List;

@Data
public class SalesInfoVo {
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
    private String customerName;

    private List<SalesProductCordVo> productCordList;



    private String salesRegDt;

}
