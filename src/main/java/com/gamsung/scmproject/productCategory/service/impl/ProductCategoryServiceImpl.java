package com.gamsung.scmproject.productCategory.service.impl;

import com.gamsung.scmproject.productCategory.mapper.ProductCategoryMapper;
import com.gamsung.scmproject.productCategory.service.ProductCategoryService;
import com.gamsung.scmproject.productCategory.vo.ProductCategoryVo;
import com.gamsung.scmproject.productModel.vo.ProductStatusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {


    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public List<ProductCategoryVo>selectProductCategoryList(String state) {
        List<ProductCategoryVo> list = productCategoryMapper.selectProductCategoryList(state);
//        List<ProductCategoryEntity> all = productCategoryRepository.findAll();
        return list;
    }

    @Override
    public void registrationProductCategory(ProductCategoryVo params) {
        productCategoryMapper.insertProductCategory(params);
//        ProductCategoryEntity categoryEntity = params.parseProductCategoryEntity();
//        ProductCategoryEntity save = productCategoryRepository.save(categoryEntity);
    }

    @Override
    public List<ProductStatusVo> selectProductStatusList() {
        return productCategoryMapper.selectProductStatusList();
    }
}
