package com.gamsung.scmproject.order.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class OrderListParamVo {
    private List<Long> orderIdList;
}
