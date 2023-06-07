package com.gamsung.scmproject.delivery.service.impl;

import com.gamsung.scmproject.common.util.TransferCenterCheck;
import com.gamsung.scmproject.delivery.mapper.DeliveryMapper;
import com.gamsung.scmproject.delivery.mapper.DeliveryStaffMapper;
import com.gamsung.scmproject.delivery.service.DeliveryService;
import com.gamsung.scmproject.delivery.vo.AvailableStaffInfoVo;
import com.gamsung.scmproject.delivery.vo.DeliveryAssignVo;
import com.gamsung.scmproject.order.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryMapper deliveryMapper;
    @Autowired
    private DeliveryStaffMapper deliveryStaffMapper;

    @Autowired
    private OrderMapper orderMapper;


    @Override
    public int batchAssignDelivery() {
        //현재 orderState=1이면서 , orderReq가 내일인 order를 orderInfo에서 List scann한다
        List<DeliveryAssignVo> list = deliveryMapper.selectDeliveryUnassignedOrderList();
        log.info("list : {}",list);
        log.info("list.size : {}",list.size());
        if(list == null || list.size() == 0) return 0;

        int success = 0;
        for (DeliveryAssignVo param : list) {
            success += assignDelivery(param);
        }
        return success;
    }

    @Transactional
    public int assignDelivery(DeliveryAssignVo param) {
        //주소 정보를 가져와서 어느 tc에 할당될 것인지를 확인한다.
        //해당 TC소속 기사중에, 익일 배송이 잡힌 건수가 5건 이하인 기사 1명을 불러온다.
        //해당 TC와 기사의 id값을 delivery에 등록한다.

        String tc = TransferCenterCheck.tcCheck(param.getCustomerAddressFirst());
        param.setTc(tc);
//        param.setDeliveryState("1");
        String expectedDt = param.getDeliveryReqDt();

        AvailableStaffInfoVo deliveryStaffOne = deliveryStaffMapper.selectAvailableDeliveryStaffOne(tc, expectedDt);
        param.setDeliveryStaffId(deliveryStaffOne.getId());
        param.setExpectedDeliveryDt(expectedDt);
        param.setState("2");
        int row = deliveryMapper.insertAssignDelivery(param);
        orderMapper.updateOrderState(param.getId(),"2");
        return row;
    }
}
