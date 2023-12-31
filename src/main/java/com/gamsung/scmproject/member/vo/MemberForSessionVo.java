package com.gamsung.scmproject.member.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberForSessionVo {

    private Long id;
    private String department;
    private String departmentId;
    private String email;
    private String role;
    private String name;


    public MemberForSessionVo(){
    }

    public MemberForSessionVo(MemberVo memberVo){
        this.id = memberVo.getId();
        this.role = memberVo.getRole();
        this.department = memberVo.getDepartment();
        this.departmentId = memberVo.getDepartmentId();
        this.email = memberVo.getEmail();
        this.name = memberVo.getName();
    }

}
