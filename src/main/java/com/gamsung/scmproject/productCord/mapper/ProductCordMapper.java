package com.gamsung.scmproject.productCord.mapper;

import com.gamsung.scmproject.productCord.vo.ProductCordVo;
import com.gamsung.scmproject.productCord.vo.ProductCordVoForList;
import com.gamsung.scmproject.productCord.vo.ProductCordWithVendorAndProductModelVo;
import com.gamsung.scmproject.productModel.vo.ProductModelVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@Mapper
public interface ProductCordMapper {
    void insertProductCord(ProductCordVo params) throws Exception;

    List<ProductCordVoForList> productCordList(String state);

    ProductCordWithVendorAndProductModelVo selectProductModelInfoByVendorIdAndProductCord(
            @Qualifier("productCord") String productCord,@Qualifier("vendorId") Long vendorId);
}
