package com.gamsung.scmproject.delivery.mapper;

import com.gamsung.scmproject.delivery.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.List;

@Mapper
public interface DeliveryStaffMapper {
    int insertDeliveryStaff(DeliveryStaffRegistrationVo params);

    List<TransportCenterVo> selectTcInfoList();

    List<DeliveryStaffInfoVo> selectDeliveryStaffList();

    AvailableStaffInfoVo selectAvailableDeliveryStaffOne(@Qualifier("tc") String tc, @Qualifier("expectedDt") String expectedDt);

    List<DeliveryInfoVo> selectDeliveryStaffListByTc(@Qualifier("tc") String tc);
}
