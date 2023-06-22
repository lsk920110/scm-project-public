package com.gamsung.scmproject.salesInfo.mapper;

import com.gamsung.scmproject.salesInfo.vo.SalesInfoVo;
import com.gamsung.scmproject.salesInfo.vo.SalesProductCordVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@Mapper
public interface SalesInfoMapper {
    List<SalesInfoVo> selectTodayDeliveryCompletionList();

    void insertSalesInfo(SalesInfoVo salesInfoVo);

    void insertSalesProductCord(SalesProductCordVo productInfo);

    List<SalesInfoVo> selectInfoListFromSalesInfo(
            @Qualifier("vendorId") Long vendorId,
            @Qualifier("startDt") String startDt,
            @Qualifier("endDt") String endDt
    );

    int selectSalesInfo(SalesInfoVo productInfo);
}
