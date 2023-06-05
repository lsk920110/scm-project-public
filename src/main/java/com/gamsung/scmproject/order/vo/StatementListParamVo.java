package com.gamsung.scmproject.order.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class StatementListParamVo {
    private List<Long> statementIdList;
}
