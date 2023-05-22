package com.gamsung.scmproject.productModel.mapper;

import com.gamsung.scmproject.productModel.vo.ProductModelForListVo;
import com.gamsung.scmproject.productModel.vo.ProductModelVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductModelMapper {


    List<ProductModelForListVo> selectProductModelAll();

    void insertProductModel(ProductModelVo params);
}