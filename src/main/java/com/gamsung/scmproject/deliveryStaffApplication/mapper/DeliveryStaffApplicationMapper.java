package com.gamsung.scmproject.deliveryStaffApplication.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeliveryStaffApplicationMapper {
    void deliveryStaffInfoById(Long deliveryStaffId);
}
