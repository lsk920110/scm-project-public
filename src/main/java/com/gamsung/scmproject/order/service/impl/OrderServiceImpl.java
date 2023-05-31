package com.gamsung.scmproject.order.service.impl;

import com.gamsung.scmproject.order.mapper.OrderMapper;
import com.gamsung.scmproject.order.service.OrderService;
import com.gamsung.scmproject.order.vo.OrderProductCordVo;
import com.gamsung.scmproject.order.vo.OrderRegistrationInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired private OrderMapper orderMapper;

    @Transactional
    @Override
    public void statementRegistration(OrderRegistrationInfoVo params) {
        params.setState("1");
        //전표 생성
        orderMapper.insertStatement(params);
        int orderSeq = 1;
        for (OrderProductCordVo productCord: params.getOrderProductCordArray()) {
            productCord.setStatementId(params.getId());
            productCord.setOrderSeq(orderSeq);
            orderSeq ++;
        }

        //제품 생성
        orderMapper.insertOrderProducts(params.getOrderProductCordArray());
    }


    @Override
    public void orderRegistration(OrderRegistrationInfoVo params) {
        orderMapper.insertOrderInfo(params);
//        orderMapper.insertOrder(params);
    }
}
