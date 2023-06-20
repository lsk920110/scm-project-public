package com.gamsung.scmproject.member.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVo {
    private Long id;
    private String name;
    private String department;
    private String departmentId;
    private String email;
    private String password;
    private String birth;
    private String state;
    private String role;
}
