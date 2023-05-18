package com.gamsung.scmproject.member.mapper;

import com.gamsung.scmproject.member.vo.MemberVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    int insertMember(MemberVo params);

    MemberVo selectMemberForLogin(Long id);

    int duplicateEmailCheck(String email);
}
