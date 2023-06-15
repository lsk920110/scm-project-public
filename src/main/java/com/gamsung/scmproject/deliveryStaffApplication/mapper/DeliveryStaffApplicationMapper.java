package com.gamsung.scmproject.deliveryStaffApplication.mapper;

import com.gamsung.scmproject.delivery.vo.DeliveryInfoVo;
import com.gamsung.scmproject.deliveryStaffApplication.vo.DeliveryStateUpdateParamVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@Mapper
public interface DeliveryStaffApplicationMapper {
    void deliveryStaffInfoById(Long deliveryStaffId);

    List<DeliveryInfoVo> selectDeliveryListByStaffId(@Qualifier("staffId") String staffId);

    void updateDeliveryState(DeliveryStateUpdateParamVo params);
}
