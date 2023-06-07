package com.gamsung.scmproject.delivery.mapper;

import com.gamsung.scmproject.delivery.vo.DeliveryAssignVo;
import com.gamsung.scmproject.delivery.vo.DeliveryInfoVo;
import com.gamsung.scmproject.delivery.vo.DeliverySearchCriteriaVo;
import com.gamsung.scmproject.delivery.vo.DeliveryStaffRegistrationVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeliveryMapper {

    int insertAssignDelivery(DeliveryAssignVo param);

    List<DeliveryAssignVo> selectDeliveryUnassignedOrderList();

    List<DeliveryInfoVo> selectDeliveryList(DeliverySearchCriteriaVo params);
}
