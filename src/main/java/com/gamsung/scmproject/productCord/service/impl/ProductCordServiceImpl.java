package com.gamsung.scmproject.productCord.service.impl;

import com.gamsung.scmproject.productCord.mapper.ProductCordMapper;
import com.gamsung.scmproject.productCord.service.ProductCordService;
import com.gamsung.scmproject.productCord.vo.ProductCordVo;
import com.gamsung.scmproject.productCord.vo.ProductCordVoForList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCordServiceImpl implements ProductCordService {
    @Autowired
    private ProductCordMapper productCordMapper;

    @Override
    public void insertProductCord(ProductCordVo params) throws Exception{
        productCordMapper.insertProductCord(params);
    }

    @Override
    public List<ProductCordVoForList> productCordList(String state) {
        return productCordMapper.productCordList(state);
    }
}
