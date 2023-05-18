package com.gamsung.scmproject.productCategory.service.impl;

import com.gamsung.scmproject.productCategory.mapper.ProductCategoryMapper;
import com.gamsung.scmproject.productCategory.service.ProductCategoryService;
import com.gamsung.scmproject.productCategory.vo.ProductCategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {


    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public List<ProductCategoryVo>selectProductCategoryList() {
        List<ProductCategoryVo> list = productCategoryMapper.selectProductCategoryList();
//        List<ProductCategoryEntity> all = productCategoryRepository.findAll();
        return list;
    }

    @Override
    public void registrationProductCategory(ProductCategoryVo params) {
        productCategoryMapper.insertProductCategory(params);
//        ProductCategoryEntity categoryEntity = params.parseProductCategoryEntity();
//        ProductCategoryEntity save = productCategoryRepository.save(categoryEntity);
    }
}
