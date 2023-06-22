package com.gamsung.scmproject.batch.service;

import com.gamsung.scmproject.salesInfo.service.SalesInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BatchScheduler {


    @Autowired private SalesInfoService salesInfoService;
    @Scheduled(fixedDelay = 10000)
    public void salesInfoRegistration() throws InterruptedException {
        log.info("batch 실행");
        salesInfoService.batchSalesInfo();
        log.info("batch 종료");
    }

}
