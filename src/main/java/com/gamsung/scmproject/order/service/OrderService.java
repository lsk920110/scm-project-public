package com.gamsung.scmproject.order.service;

import com.gamsung.scmproject.order.vo.OrderRegistrationInfoVo;

public interface OrderService {
    void orderRegistration(OrderRegistrationInfoVo params);

    void statementRegistration(OrderRegistrationInfoVo params);
}
