package com.gamsung.scmproject.member.service;

import com.gamsung.scmproject.common.vo.DepartmentVo;
import com.gamsung.scmproject.member.vo.LoginResultVo;
import com.gamsung.scmproject.member.vo.MemberVo;

import java.util.List;

public interface MemberService {

    void joinMember(MemberVo params);

    LoginResultVo loginMember(MemberVo params);

    Boolean emailDuplicatedCheck(String email);

    MemberVo selectMemberInfoById(Long id);

    List<MemberVo> selectMemberList();

    List<DepartmentVo> selectDepartmentList();

    void updateMemberInfo(MemberVo params);
}
