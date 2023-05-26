package com.gamsung.scmproject.productCord.service;

import com.gamsung.scmproject.productCord.mapper.ProductCordMapper;
import com.gamsung.scmproject.productCord.vo.ProductCordVo;
import com.gamsung.scmproject.productCord.vo.ProductCordVoForList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductCordService{


    void insertProductCord(ProductCordVo params)throws Exception;

    List<ProductCordVoForList> productCordList(String state);
}
