package com.gamsung.scmproject.salesInfo.service.impl;

import com.gamsung.scmproject.salesInfo.mapper.SalesInfoMapper;
import com.gamsung.scmproject.salesInfo.service.SalesInfoService;
import com.gamsung.scmproject.salesInfo.vo.SalesInfoVo;
import com.gamsung.scmproject.salesInfo.vo.SalesProductCordVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class SalesInfoServiceImpl implements SalesInfoService {

    @Autowired private SalesInfoMapper salesInfoMapper;

    @Override
    public List<SalesInfoVo> batchSalesInfo() {
        List<SalesInfoVo> list = salesInfoMapper.selectTodayDeliveryCompletionList();
        int success = 0;
        for (SalesInfoVo salesInfo:list) {
            int row = salesInfoMapper.selectSalesInfo(salesInfo);
            if(row == 0){
                insertSalesBatch(salesInfo);
                success += 1;
            }
        }
        log.info("전체 배송완료건 : {} 건 , 실제 반영건 : {} 건",list.size(),success);
        return list;
    }

    @Transactional
    public void insertSalesBatch(SalesInfoVo salesInfoVo){

        salesInfoMapper.insertSalesInfo(salesInfoVo);
        for (SalesProductCordVo productInfo: salesInfoVo.getProductCordList()) {
            productInfo.setSalesId(salesInfoVo.getId());
            salesInfoMapper.insertSalesProductCord(productInfo);
        }
    }


    @Override
    public List<SalesInfoVo> selectInfo(Long vendorId, String startDt, String endDt) {
        return salesInfoMapper.selectInfoListFromSalesInfo(vendorId,startDt,endDt);
    }

}
