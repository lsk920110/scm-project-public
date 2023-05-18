package com.gamsung.scmproject.common.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultVo<T>{

    private String errorCode;
    private String errorMessage;
    private T result;

    public static ResultVo<?> successResult(){
        ResultVo resultVo = new ResultVo<>();
        resultVo.setErrorCode("0000");
        resultVo.setErrorMessage("success");
        return resultVo;
    }
    public static ResultVo failedLogin(){
        ResultVo<Object> resultVo = new ResultVo<>();
        resultVo.setErrorCode("0001");
        resultVo.setErrorMessage("loginFailed");
        return resultVo;
    }
}
