package com.gamsung.scmproject.productCategory.service;

import com.gamsung.scmproject.productCategory.model.ProductCategoryEntity;
import com.gamsung.scmproject.productCategory.repository.ProductCategoryRepository;
import com.gamsung.scmproject.productCategory.vo.ProductCategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{


    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategoryEntity> selectProductCategoryList() {
        List<ProductCategoryEntity> all = productCategoryRepository.findAll();
        return all;
    }

    @Override
    public void registrationProductCategory(ProductCategoryVo params) {
        ProductCategoryEntity categoryEntity = params.parseProductCategoryEntity();
        ProductCategoryEntity save = productCategoryRepository.save(categoryEntity);
    }
}
