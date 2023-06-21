package com.gamsung.scmproject.member.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResultVo {

    private Long id;
//    private String name;
    private MemberVo memberVo;
    private Boolean loginSuccess;

}
