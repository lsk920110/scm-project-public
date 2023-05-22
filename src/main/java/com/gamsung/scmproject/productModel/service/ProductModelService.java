package com.gamsung.scmproject.productModel.service;

import com.gamsung.scmproject.productModel.vo.ProductModelVo;

import java.util.List;

public interface ProductModelService {
    List<ProductModelVo> selectProductModelAll();


    void insertProductModel(ProductModelVo params);
}
