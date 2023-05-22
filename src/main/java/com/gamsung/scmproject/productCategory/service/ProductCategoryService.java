package com.gamsung.scmproject.productCategory.service;

import com.gamsung.scmproject.productCategory.vo.ProductCategoryVo;
import com.gamsung.scmproject.productModel.vo.ProductStatusVo;

import java.util.List;

public interface ProductCategoryService {

    List<ProductCategoryVo> selectProductCategoryList(String state);

    void registrationProductCategory(ProductCategoryVo params);

    List<ProductStatusVo> selectProductStatusList();
}
