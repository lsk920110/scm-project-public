package com.gamsung.scmproject.order.service;

import com.gamsung.scmproject.order.vo.OrderInfoForListVo;
import com.gamsung.scmproject.order.vo.OrderRegistrationInfoVo;
import com.gamsung.scmproject.order.vo.OrderSearchParamVo;

import java.util.List;

public interface OrderService {
    void orderRegistration(OrderRegistrationInfoVo params);

    void statementRegistration(OrderRegistrationInfoVo params);

    List<OrderInfoForListVo> selectOrderList(OrderSearchParamVo params);
}
