package com.gamsung.scmproject.common.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultVo<T>{

    private String errorCode;
    private String errorMessage;
    private T result;

}
