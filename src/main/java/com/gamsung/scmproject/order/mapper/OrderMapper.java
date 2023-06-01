package com.gamsung.scmproject.order.mapper;

import com.gamsung.scmproject.order.vo.OrderInfoForListVo;
import com.gamsung.scmproject.order.vo.OrderProductCordVo;
import com.gamsung.scmproject.order.vo.OrderRegistrationInfoVo;
import com.gamsung.scmproject.order.vo.OrderSearchParamVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    void insertStatement(OrderRegistrationInfoVo params);

    void insertOrderProducts(List<OrderProductCordVo> params);

    void insertOrderInfo(OrderRegistrationInfoVo params);

    List<OrderInfoForListVo> selectOrderList(OrderSearchParamVo params);
}
