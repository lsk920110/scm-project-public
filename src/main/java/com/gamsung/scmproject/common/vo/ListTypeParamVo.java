package com.gamsung.scmproject.common.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ListTypeParamVo<T> {

    List<T> list;

}
