package com.gamsung.scmproject.order.service;

import com.gamsung.scmproject.order.vo.*;

import java.util.List;

public interface OrderService {
    OrderInsertVo orderInsert(Long statementId);

    Long statementRegistration(OrderRegistrationInfoVo params);

    StatementInfoVo orderInfoByStatementId(Long statementId);

    List<OrderInfoForListVo> selectOrderList(OrderSearchParamVo params);

    int updateStatement(OrderRegistrationInfoVo params);

    List<OrderInsertVo> insertOrderList(List<Long> statementIds);

    void statementListDelete(List<Long> statementIdList);

    void orderListDelete(List<Long> orderIdList);
}
