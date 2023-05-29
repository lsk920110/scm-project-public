package com.gamsung.scmproject.productCord.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductCordWithVendorAndProductModelVo {
    private Long vendorId;
    private String productCord;
    private Long supplyPrice;
    private Long supplyPriceVat;
    private String modelCord;

}
