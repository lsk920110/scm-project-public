package com.gamsung.scmproject.delivery.service;

import com.gamsung.scmproject.delivery.vo.DeliveryInfoVo;
import com.gamsung.scmproject.delivery.vo.DeliveryStaffInfoVo;
import com.gamsung.scmproject.delivery.vo.DeliveryStaffRegistrationVo;
import com.gamsung.scmproject.delivery.vo.TransportCenterVo;

import java.util.List;

public interface DeliveryStaffService {
    int insertDeliveryStaff(DeliveryStaffRegistrationVo params);

    List<TransportCenterVo> tcInfoList();

    List<DeliveryStaffInfoVo> selectDeliveryStaffList();

    List<DeliveryInfoVo> selectDeliveryStaffListByTc(String tc);
}
