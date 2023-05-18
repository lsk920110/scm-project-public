package com.gamsung.scmproject.productCategory.mapper;

import com.gamsung.scmproject.productCategory.vo.ProductCategoryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductCategoryMapper {
    List<ProductCategoryVo> selectProductCategoryList();

    void insertProductCategory(ProductCategoryVo params);
}
