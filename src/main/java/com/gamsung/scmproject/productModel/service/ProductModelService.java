package com.gamsung.scmproject.productModel.service;

import com.gamsung.scmproject.productModel.vo.ProductModelForListVo;
import com.gamsung.scmproject.productModel.vo.ProductModelVo;

import java.util.List;

public interface ProductModelService {
    List<ProductModelForListVo> selectProductModelAll();


    void insertProductModel(ProductModelVo params);

    List<ProductModelVo> selectProductModelByProductCategoryId(Long productCategoryId);

}
