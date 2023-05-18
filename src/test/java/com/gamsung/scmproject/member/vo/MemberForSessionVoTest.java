package com.gamsung.scmproject.member.vo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberForSessionVoTest {

    @Test
    void memberConstructorTest(){
        MemberVo memberVo = new MemberVo();
        memberVo.setId(100000L);
        memberVo.setPassword("1234");
        memberVo.setEmail("lsk@rowem.com");
        memberVo.setRole("1");
        memberVo.setBirth("19920110");
        memberVo.setDepartment("1");
        memberVo.setState("1");
        MemberForSessionVo memberForSessionVo = new MemberForSessionVo(memberVo);

        System.out.println(memberForSessionVo.toString());
    }

}