package com.gamsung.scmproject.order.service.impl;

import com.gamsung.scmproject.order.mapper.OrderMapper;
import com.gamsung.scmproject.order.service.OrderService;
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
        //전표 생성
        orderMapper.insertStatement(params);

        //제품 생성
        orderMapper.insertOrderProducts(params);
    }


    @Override
    public void orderRegistration(OrderRegistrationInfoVo params) {

//        orderMapper.insertOrder(params);
    }
}
