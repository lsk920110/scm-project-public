package com.gamsung.scmproject.order.service;

import com.gamsung.scmproject.common.vo.ResultVo;
import com.gamsung.scmproject.order.vo.OrderInfoForListVo;
import com.gamsung.scmproject.order.vo.OrderRegistrationInfoVo;
import com.gamsung.scmproject.order.vo.OrderSearchParamVo;
import com.gamsung.scmproject.order.vo.StatementInfoVo;

import java.util.List;

public interface OrderService {
    void orderRegistration(OrderRegistrationInfoVo params);

    ResultVo<?> statementRegistration(OrderRegistrationInfoVo params , String callback);

    StatementInfoVo orderInfoByStatementId(Long statementId);

    List<OrderInfoForListVo> selectOrderList(OrderSearchParamVo params);

    ResultVo<?> updateStatement(OrderRegistrationInfoVo params , String callback);
}
