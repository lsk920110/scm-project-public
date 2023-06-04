package com.gamsung.scmproject.order.service.impl;

import com.gamsung.scmproject.order.mapper.OrderMapper;
import com.gamsung.scmproject.order.vo.OrderInfoForListVo;
import com.gamsung.scmproject.order.vo.OrderSearchParamVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@PropertySource("classpath:/application.properties")
class OrderServiceImplTest {

    @Autowired private OrderMapper orderMapper;

    @Test
    void orderInfo(){
        System.out.println("asdasd");
        OrderSearchParamVo params = new OrderSearchParamVo();
        params.setVendorId(1000000L);
        params.setSearchCriteria("1");
        params.setSearchContent("2500000000");
        params.setOrderCreateStartDt("2023-05-01");
        params.setOrderCreateEndDt("2023-06-01");
        params.setOrderState("1");
        params.setModelCord("DV16T8740BV");
        List<OrderInfoForListVo> resultListVo = orderMapper.selectOrderList(params);
        for (OrderInfoForListVo orderInfo: resultListVo) {
            System.out.println(orderInfo.toString());
//            System.out.println(orderInfo.getProductList().toString());
        }
        System.out.println("123123");
    }

    @Test
    void statementIdDuplicatedCheck(){
        int count = orderMapper.checkSalesNo(2500000000L);
        System.out.println("count : "+count);
    }
}