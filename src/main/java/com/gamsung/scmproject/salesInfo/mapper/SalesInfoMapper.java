package com.gamsung.scmproject.salesInfo.mapper;

import com.gamsung.scmproject.salesInfo.vo.SalesInfoVo;
import com.gamsung.scmproject.salesInfo.vo.SalesProductCordVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SalesInfoMapper {
    List<SalesInfoVo> selectTodayDeliveryCompletionList();

    void insertSalesInfo(SalesInfoVo salesInfoVo);

    void insertSalesProductCord(SalesProductCordVo productInfo);
}
