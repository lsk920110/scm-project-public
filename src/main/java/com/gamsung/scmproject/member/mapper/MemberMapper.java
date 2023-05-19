package com.gamsung.scmproject.member.mapper;

import com.gamsung.scmproject.common.vo.DepartmentVo;
import com.gamsung.scmproject.member.vo.MemberVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    int insertMember(MemberVo params);

    MemberVo selectMemberForLogin(Long id);

    int duplicateEmailCheck(String email);

    List<DepartmentVo> selectDepartmentList();

    List<MemberVo> selectMemberList();
}
