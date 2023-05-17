package com.gamsung.scmproject.productCategory.vo;


import com.gamsung.scmproject.productCategory.model.ProductCategoryEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCategoryVo {


    private long id;
    private long productSizeId;

    private String productCategory;

    private long memberId;

    public ProductCategoryEntity parseProductCategoryEntity(){

        ProductCategoryEntity entity = new ProductCategoryEntity();
        entity.setId(this.id);
        entity.setMemberId(this.memberId);
        entity.setProductCategory(this.productCategory);

        return entity;
    }



}
