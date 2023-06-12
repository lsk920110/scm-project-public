package com.gamsung.scmproject.deliveryStaffApplication.service.impl;

import com.gamsung.scmproject.deliveryStaffApplication.mapper.DeliveryStaffApplicationMapper;
import com.gamsung.scmproject.deliveryStaffApplication.service.DeliveryStaffApplicationService;
import com.gamsung.scmproject.deliveryStaffApplication.vo.DeliveryListCallByStaffIdParamVo;
import com.gamsung.scmproject.deliveryStaffApplication.vo.DeliveryStaffLoginVo;
import com.gamsung.scmproject.deliveryStaffApplication.vo.DeliveryStateUpdateParamVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryStaffApplicationServiceImpl implements DeliveryStaffApplicationService {

    @Autowired private DeliveryStaffApplicationMapper deliveryStaffApplicationMapper;

    @Override
    public void deliveryStaffLogin(DeliveryStaffLoginVo params) {
        deliveryStaffApplicationMapper.deliveryStaffInfoById(params.getDeliveryStaffId());


    }

    @Override
    public void deliveryListByStaffId(DeliveryListCallByStaffIdParamVo params) {

    }

    @Override
    public void deliveryStateUpdate(DeliveryStateUpdateParamVo params) {

    }
}
