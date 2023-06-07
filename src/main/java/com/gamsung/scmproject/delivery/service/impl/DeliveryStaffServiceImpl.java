package com.gamsung.scmproject.delivery.service.impl;

import com.gamsung.scmproject.delivery.mapper.DeliveryStaffMapper;
import com.gamsung.scmproject.delivery.service.DeliveryStaffService;
import com.gamsung.scmproject.delivery.vo.DeliveryStaffInfoVo;
import com.gamsung.scmproject.delivery.vo.DeliveryStaffRegistrationVo;
import com.gamsung.scmproject.delivery.vo.TransportCenterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryStaffServiceImpl implements DeliveryStaffService {

    @Autowired private DeliveryStaffMapper deliveryStaffMapper;


    @Override
    public int insertDeliveryStaff(DeliveryStaffRegistrationVo params) {

        int row = deliveryStaffMapper.insertDeliveryStaff(params);

        return row;
    }

    @Override
    public List<TransportCenterVo> tcInfoList() {
        return deliveryStaffMapper.selectTcInfoList();
    }

    @Override
    public List<DeliveryStaffInfoVo> selectDeliveryStaffList() {
        return deliveryStaffMapper.selectDeliveryStaffList();
    }
}
