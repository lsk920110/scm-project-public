package com.gamsung.scmproject.member.service;

import com.gamsung.scmproject.common.vo.DepartmentVo;
import com.gamsung.scmproject.member.vo.MemberVo;

import java.util.List;

public interface MemberService {

    void joinMember(MemberVo params);

    Boolean loginMember(MemberVo params);

    Boolean emailDuplicatedCheck(String email);

    MemberVo selectMember();

    List<MemberVo> selectMemberList();

    List<DepartmentVo> selectDepartmentList();
}
