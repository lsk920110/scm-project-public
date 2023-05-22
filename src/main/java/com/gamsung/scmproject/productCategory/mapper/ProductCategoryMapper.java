package com.gamsung.scmproject.productCategory.mapper;

import com.gamsung.scmproject.productCategory.vo.ProductCategoryVo;
import com.gamsung.scmproject.productModel.vo.ProductStatusVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductCategoryMapper {
    List<ProductCategoryVo> selectProductCategoryList(String state);

    void insertProductCategory(ProductCategoryVo params);

    List<ProductStatusVo> selectProductStatusList();
}
