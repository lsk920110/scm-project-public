package com.gamsung.scmproject.delivery.vo;

import com.gamsung.scmproject.productCord.vo.ProductCordVo;
import com.gamsung.scmproject.productCord.vo.ProductCordVoForList;
import lombok.Data;

import java.util.List;

@Data
public class DeliveryInfoVo {

    private Long id;
    private Long orderId;
    private String customerName;
//    private String modelCord;
//    private int orderQuantity;
    private String tc;
    private String expectedDeliveryDt;
    private String deliveryCompletionDt;
    private String deliveryState;
    private String staffName;
    private String staffPhoneNum;
    private List<ProductInfoForDelivery> list;

}

@Data
class ProductInfoForDelivery{
    private String modelCord;
    private int orderQuantity;
}
