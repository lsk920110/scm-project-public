package com.gamsung.scmproject.productCord.vo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductCordVoForList {

    private Long id;
    private Long vendorId;
    private String vendorName;
    private Long productModelId;
    private String modelCord;
    private String productCord;
    private Long supplyPrice;
    private Long supplyPriceVat;
    private LocalDateTime regDt;
    private String state;
    private Long regMemberId;
    private String name;


}
