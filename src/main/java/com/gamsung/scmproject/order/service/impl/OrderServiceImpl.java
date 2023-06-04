package com.gamsung.scmproject.order.service.impl;

import com.gamsung.scmproject.common.vo.ResultVo;
import com.gamsung.scmproject.order.mapper.OrderMapper;
import com.gamsung.scmproject.order.service.OrderService;
import com.gamsung.scmproject.order.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired private OrderMapper orderMapper;

    @Transactional
    @Override
    public ResultVo<?> statementRegistration(OrderRegistrationInfoVo params , String callback) {
        params.setState("1");
        //전표 생성
        orderMapper.insertStatement(params);
        //코드생성
        insertProductCordAboutStatement(params.getOrderProductCordArray(),params.getId());
        //주문생성
        if(callback.equals("orderRegistration")){
            orderRegistration(params);
        }
        return null;
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

    @Transactional
    @Override
    public ResultVo<?> updateStatement(OrderRegistrationInfoVo params , String callback) {
        //기존의 상품코드들은 지우기
        orderMapper.deleteProductCordListAboutStatement(params.getId());

        //statement를 update하기
        orderMapper.updateStatement(params);

        //상품코드들을 다시 insert하기
        insertProductCordAboutStatement(params.getOrderProductCordArray(),params.getId());
        //주문생성
        if(callback.equals("orderRegistration")){
            //check orderInfo 중에 saledNo 존재하는지?
            int count = orderMapper.checkSalesNo(params.getSalesNo());
            if(count > 0){
                //해당 판매번호가 존재하기 떄문에ㅔㅔ.
                log.info("판매번호가 중복된 상태입니다.");
            } else {
                orderRegistration(params);
            }
        }
        return null;
    }


    @Override
    public void orderRegistration(OrderRegistrationInfoVo params) {
        orderMapper.insertOrderInfo(params);
    }


    public void insertProductCordAboutStatement(List<OrderProductCordVo> productCordList , Long statementId){
        int orderSeq = 1;
        for (OrderProductCordVo productCord: productCordList) {
            productCord.setStatementId(statementId);
            productCord.setOrderSeq(orderSeq);
            orderSeq ++;
        }
        //제품 생성
        orderMapper.insertOrderProducts(productCordList);
    }

    public void salesNoDuplicatedCheck(String salesNo){
        int count = orderMapper.checkSalesNo(salesNo);
        if(count > 0){
            log.info("판매번호가 중복된 상태입니다.");

        } else {
        }
    }
}
