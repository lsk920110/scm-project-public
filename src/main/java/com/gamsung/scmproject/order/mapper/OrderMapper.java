package com.gamsung.scmproject.order.mapper;

import com.gamsung.scmproject.order.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@Mapper
public interface OrderMapper {
    void insertStatement(OrderRegistrationInfoVo params);

    void insertOrderProducts(List<OrderProductCordVo> params);

    void insertOrderInfo(OrderRegistrationInfoVo params);

    List<OrderInfoForListVo> selectOrderList(OrderSearchParamVo params);

    StatementInfoVo selectStatementInfo(@Qualifier("statementId") Long statementId);

    void deleteProductCordListAboutStatement(@Qualifier("statementId") Long statementId);

    void updateStatement(OrderRegistrationInfoVo params);

    int checkSalesNo(@Qualifier("salesNo") String salesNo);
}
