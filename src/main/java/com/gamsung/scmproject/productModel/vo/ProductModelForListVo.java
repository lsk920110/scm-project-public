package com.gamsung.scmproject.productModel.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ProductModelForListVo {



    private Long id;
    private Long productCategoryId;
    private String productCategory;
    private String modelCord;
    private Long stock;
    private LocalDateTime regDt;
    private String productStatus;
    private String productStatusId;
    private Long memberId;
    private String name;

}
