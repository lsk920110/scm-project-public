package com.gamsung.scmproject.deliveryStaffApplication.service;

import com.gamsung.scmproject.deliveryStaffApplication.vo.DeliveryListCallByStaffIdParamVo;
import com.gamsung.scmproject.deliveryStaffApplication.vo.DeliveryStaffLoginVo;
import com.gamsung.scmproject.deliveryStaffApplication.vo.DeliveryStateUpdateParamVo;

public interface DeliveryStaffApplicationService {
    void deliveryStaffLogin(DeliveryStaffLoginVo params);

    void deliveryListByStaffId(DeliveryListCallByStaffIdParamVo params);

    void deliveryStateUpdate(DeliveryStateUpdateParamVo params);
}
