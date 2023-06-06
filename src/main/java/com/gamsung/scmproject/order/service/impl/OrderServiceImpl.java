package com.gamsung.scmproject.order.service.impl;

import com.gamsung.scmproject.order.mapper.OrderMapper;
import com.gamsung.scmproject.order.service.OrderService;
import com.gamsung.scmproject.order.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 전표생성
     *
     * @param params
     * @param callback 안쓸예정
     * @return statementId
     */
    @Transactional
    @Override
    public Long statementRegistration(OrderRegistrationInfoVo params) {
        params.setState("1");
        //전표 생성
        int row = orderMapper.insertStatement(params);
        //코드생성
        insertProductCordAboutStatement(params.getOrderProductCordArray(), params.getId());
        return params.getId();
    }

    /**
     * @param params
     * @param callback
     * @return
     */
    @Transactional
    @Override
    public int updateStatement(OrderRegistrationInfoVo params) {
        //기존의 상품코드들은 지우기
        orderMapper.deleteProductCordListAboutStatement(params.getId());

        //statement를 update하기
        int row = orderMapper.updateStatement(params);

        //상품코드들을 다시 insert하기
        insertProductCordAboutStatement(params.getOrderProductCordArray(), params.getId());
        //주문생성

        return row;
    }

    @Override
    public List<OrderInfoForListVo> selectOrderList(OrderSearchParamVo params) {
        return orderMapper.selectOrderList(params);
    }

    @Override
    public StatementInfoVo orderInfoByStatementId(Long statementId) {

        StatementInfoVo statementInfoVo = orderMapper.selectStatementInfo(statementId);
        return statementInfoVo;
    }


    /**
     *
     * @param statementIds
     * @return 고민좀 해보기...
     */
    @Override
    public List<OrderInsertVo> insertOrderList(List<Long> statementIds) {

        int successRows = 0;
        List<OrderInsertVo> list = new ArrayList<>();
        for (Long statementId : statementIds) {
            list.add(orderInsert(statementId));
        }
        return list;
    }

    @Override
    public void statementListDelete(List<Long> statementIdList) {
        for (Long statementId : statementIdList) {
            statementDelete(statementId);
        }
    }

    public void statementDelete(Long statementId){
        orderMapper.deleteStatement(statementId);
    }

    @Override
    public void orderListDelete(List<Long> orderIdList) {

        for (Long orderId : orderIdList) {
            orderDelete(orderId);
        }
    }

    @Transactional
    public void orderDelete(Long orderId){
//        Long statementId = orderMapper.selectOrderInfoByOrderId(orderId);
        orderMapper.deleteOrder(orderId);
//        statementDelete(statementId);
    }


    @Override
    public OrderInsertVo orderInsert(Long statementId) {
        OrderInsertVo orderInsertVo = new OrderInsertVo();
        StatementInfoVo statementInfoVo = orderMapper.selectStatementInfo(statementId);
        orderInsertVo.setStatementId(statementId);
        boolean duplicatedCheck = salesNoDuplicatedCheck(statementInfoVo.getSalesNo());
        orderInsertVo.setSuccess(!duplicatedCheck);
        if (!duplicatedCheck) {
            orderMapper.insertOrderInfo(orderInsertVo);
            log.info("orderInsertVo result : {}",orderInsertVo);
        } else {
            orderInsertVo.setFailedReason("salesNoDuplicated");
        }
        return orderInsertVo;
    }


    public void insertProductCordAboutStatement(List<OrderProductCordVo> productCordList, Long statementId) {
        int orderSeq = 1;
        for (OrderProductCordVo productCord : productCordList) {
            productCord.setStatementId(statementId);
            productCord.setOrderSeq(orderSeq);
            orderSeq++;
        }
        //제품 생성
        orderMapper.insertOrderProducts(productCordList);
    }

    public Boolean salesNoDuplicatedCheck(String salesNo) {
        int count = orderMapper.checkSalesNo(salesNo);
        return count > 0;
    }
}
