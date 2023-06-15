package com.gamsung.scmproject.deliveryStaffApplication.service;

import com.gamsung.scmproject.delivery.vo.DeliveryInfoVo;
import com.gamsung.scmproject.deliveryStaffApplication.vo.DeliveryStaffLoginVo;
import com.gamsung.scmproject.deliveryStaffApplication.vo.DeliveryStateUpdateParamVo;

import java.util.List;

public interface DeliveryStaffApplicationService {
    void deliveryStaffLogin(DeliveryStaffLoginVo params);

    void updateDeliveryState(DeliveryStateUpdateParamVo params);

    List<DeliveryInfoVo> deliveryListByStaffId(String staffId);
}
