package com.gamsung.scmproject.deliveryStaffApplication.service.impl;

import com.gamsung.scmproject.delivery.vo.DeliveryInfoVo;
import com.gamsung.scmproject.deliveryStaffApplication.mapper.DeliveryStaffApplicationMapper;
import com.gamsung.scmproject.deliveryStaffApplication.service.DeliveryStaffApplicationService;
import com.gamsung.scmproject.deliveryStaffApplication.vo.DeliveryStaffLoginVo;
import com.gamsung.scmproject.deliveryStaffApplication.vo.DeliveryStateUpdateParamVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryStaffApplicationServiceImpl implements DeliveryStaffApplicationService {

    @Autowired private DeliveryStaffApplicationMapper deliveryStaffApplicationMapper;

    @Override
    public void deliveryStaffLogin(DeliveryStaffLoginVo params) {
        deliveryStaffApplicationMapper.deliveryStaffInfoById(params.getDeliveryStaffId());


    }

    @Override
    public List<DeliveryInfoVo> deliveryListByStaffId(String staffId) {

        return deliveryStaffApplicationMapper.selectDeliveryListByStaffId(staffId);
//        return null;
    }

    @Override
    public void updateDeliveryState(DeliveryStateUpdateParamVo params) {
        deliveryStaffApplicationMapper.updateDeliveryState(params);
    }
}
