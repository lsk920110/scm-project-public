package com.gamsung.scmproject.callcenter.vo;

import lombok.Data;

@Data
public class HistoryInfoVo {
    private Long id;
    private Long orderId;
    private String memo;
    private String regDt;
    private String state;
    private Long regMemberId;
}
