package com.gamsung.scmproject.delivery.vo;

import com.gamsung.scmproject.order.vo.OrderProductCordVo;
import com.gamsung.scmproject.productCord.vo.ProductCordVo;
import com.gamsung.scmproject.productCord.vo.ProductCordVoForList;
import lombok.Data;

import java.util.List;

@Data
public class DeliveryInfoVo {

    private Long id;
    private Long orderId;
    private Long statementId;
    private String customerName;
//    private String modelCord;
//    private int orderQuantity;
    private String tc;
    private String expectedDeliveryDt;
    private String deliveryCompletionDt;
    private String deliveryState;
    private String staffName;
    private String staffPhoneNum;
    private List<OrderProductCordVo> productList;

}
