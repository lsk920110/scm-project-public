package com.gamsung.scmproject.member.service.impl;

import com.gamsung.scmproject.common.vo.DepartmentVo;
import com.gamsung.scmproject.member.mapper.MemberMapper;
import com.gamsung.scmproject.member.service.MemberService;
import com.gamsung.scmproject.member.vo.LoginResultVo;
import com.gamsung.scmproject.member.vo.MemberForSessionVo;
import com.gamsung.scmproject.member.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {


    @Autowired
    private MemberMapper memberMapper;

    @Override
    public void joinMember(MemberVo params) {
        //encrypt
        String password = params.getPassword();
        params.setState("1");

        int row = memberMapper.insertMember(params);
    }

    @Override
    public LoginResultVo loginMember(MemberVo params) {
        MemberVo loginMember = memberMapper.selectMemberForLogin(params.getId());
        LoginResultVo loginResultVo = new LoginResultVo();
        Boolean result;
        if(loginMember == null){
            //결과 자체가 없음
            loginResultVo.setLoginSuccess(false);
            return loginResultVo;
        } else {
            result = params.getPassword().equals(loginMember.getPassword());
            loginResultVo.setLoginSuccess(result);
            if(result){
                loginResultVo.setId(loginMember.getId());
                loginResultVo.setName(loginMember.getName());
            }

        }
        return loginResultVo;
    }

    @Override
    public Boolean emailDuplicatedCheck(String email) {
        int result = memberMapper.duplicateEmailCheck(email);
        return result > 0;
    }

    @Override
    public MemberVo selectMember() {
        return null;
    }

    @Override
    public List<MemberVo> selectMemberList() {
        return memberMapper.selectMemberList();
    }

    @Override
    public List<DepartmentVo> selectDepartmentList() {
        return memberMapper.selectDepartmentList();
    }
}
