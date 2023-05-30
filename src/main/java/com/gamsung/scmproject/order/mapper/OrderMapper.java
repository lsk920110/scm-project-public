package com.gamsung.scmproject.order.mapper;

import com.gamsung.scmproject.order.vo.OrderRegistrationInfoVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    void insertStatement(OrderRegistrationInfoVo params);

    void insertOrderProducts(OrderRegistrationInfoVo params);
}
