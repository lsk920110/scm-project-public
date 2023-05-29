package com.gamsung.scmproject.productModel.service.impl;
import com.gamsung.scmproject.productModel.mapper.ProductModelMapper;
import com.gamsung.scmproject.productModel.service.ProductModelService;
import com.gamsung.scmproject.productModel.vo.ProductModelForListVo;
import com.gamsung.scmproject.productModel.vo.ProductModelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductModelServiceImpl implements ProductModelService {

    @Autowired
    private ProductModelMapper productModelMapper;

    @Override
    public List<ProductModelForListVo> selectProductModelAll() {
        return productModelMapper.selectProductModelAll();
    }

    @Override
    public void insertProductModel(ProductModelVo params) {
        productModelMapper.insertProductModel(params);
    }

    @Override
    public List<ProductModelVo> selectProductModelByProductCategoryId(Long productCategoryId) {
        return productModelMapper.selectProductModelByProductCategoryId(productCategoryId);
    }




}
