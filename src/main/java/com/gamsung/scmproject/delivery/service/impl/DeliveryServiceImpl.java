package com.gamsung.scmproject.delivery.service.impl;

import com.gamsung.scmproject.delivery.service.DeliveryService;
import com.gamsung.scmproject.delivery.vo.DeliveryAssignVo;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Override
    public void batchAssignDelivery() {
        //현재 orderState=1이면서 ,  order를 orderInfo에서 List scann한다
        //orderInfo left outer join

        //orderId 를 꺼내면서 delivery정보를 만든다.
    }

    public void assignDelivery(DeliveryAssignVo param){
        //주소 정보를 가져와서 어느 tc에 할당될 것인지를 확인한다.
        param.getCustomerAddressFirst();

    }
}
