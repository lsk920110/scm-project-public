package com.gamsung.scmproject.delivery.service;

import com.gamsung.scmproject.delivery.vo.DeliveryInfoVo;
import com.gamsung.scmproject.delivery.vo.DeliverySearchCriteriaVo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DeliveryService {
    int batchAssignDelivery();

    List<DeliveryInfoVo> selectDeliveryList(DeliverySearchCriteriaVo params);
}
