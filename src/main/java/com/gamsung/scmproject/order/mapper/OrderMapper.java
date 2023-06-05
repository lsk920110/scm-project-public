package com.gamsung.scmproject.order.mapper;

import com.gamsung.scmproject.order.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@Mapper
public interface OrderMapper {
    int insertStatement(OrderRegistrationInfoVo params);

    int insertOrderProducts(List<OrderProductCordVo> params);

    int insertOrderInfo(OrderInsertVo statementId);

    List<OrderInfoForListVo> selectOrderList(OrderSearchParamVo params);

    StatementInfoVo selectStatementInfo(@Qualifier("statementId") Long statementId);

    int deleteProductCordListAboutStatement(@Qualifier("statementId") Long statementId);

    int updateStatement(OrderRegistrationInfoVo params);

    int checkSalesNo(@Qualifier("salesNo") String salesNo);

    void deleteStatement(@Qualifier("statementId") Long statementId);

    Long selectOrderInfoByOrderId(@Qualifier("orderId") Long orderId);

    void deleteOrder(Long orderId);
}
