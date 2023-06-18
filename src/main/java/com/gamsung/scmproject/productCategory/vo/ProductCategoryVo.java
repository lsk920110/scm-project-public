package com.gamsung.scmproject.productCategory.vo;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductCategoryVo {


    private long id;
    private String productCategory;

    private String state;
    private long memberId;
    private LocalDateTime regDt;
    private String name;





}
