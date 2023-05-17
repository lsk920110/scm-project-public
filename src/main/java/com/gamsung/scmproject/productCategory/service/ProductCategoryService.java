package com.gamsung.scmproject.productCategory.service;

import com.gamsung.scmproject.productCategory.model.ProductCategoryEntity;
import com.gamsung.scmproject.productCategory.vo.ProductCategoryVo;

import java.util.List;

public interface ProductCategoryService {

    List<ProductCategoryEntity> selectProductCategoryList();

    void registrationProductCategory(ProductCategoryVo params);

}
