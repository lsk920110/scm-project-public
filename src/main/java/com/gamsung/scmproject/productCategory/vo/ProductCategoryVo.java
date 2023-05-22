package com.gamsung.scmproject.productCategory.vo;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductCategoryVo {


    private long id;
    private long productSizeId;

    private String productCategory;

    private long memberId;
    private LocalDateTime regDt;





}
