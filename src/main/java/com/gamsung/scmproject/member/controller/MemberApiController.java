package com.gamsung.scmproject.member.controller;

import com.gamsung.scmproject.common.constant.ErrorCode;
import com.gamsung.scmproject.common.constant.ModelObjectKey;
import com.gamsung.scmproject.common.constant.SessionKeys;
import com.gamsung.scmproject.common.controller.BaseController;
import com.gamsung.scmproject.common.vo.DepartmentVo;
import com.gamsung.scmproject.common.vo.ResultVo;
import com.gamsung.scmproject.member.service.MemberService;
import com.gamsung.scmproject.member.vo.LoginResultVo;
import com.gamsung.scmproject.member.vo.MemberForSessionVo;
import com.gamsung.scmproject.member.vo.MemberVo;
import com.gamsung.scmproject.menubar.service.MenuBarService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/member")
public class MemberApiController extends BaseController {


    @Autowired
    private MemberService memberService;
    @Autowired
    private MenuBarService menuBarService;

    //회원 등록 페이지

    //회원 리스트 가져오기

    @GetMapping(value = "")
    public ResultVo<?> memberList() {
        List<MemberVo> memberList = memberService.selectMemberList();
        return makeResultVo(ErrorCode.SUCCESS,memberList);
    }

    //회원가입
    @PostMapping("/join")
    public ResultVo<?> memberJoinApi(@RequestBody MemberVo memberVo) {
        memberService.joinMember(memberVo);
        return makeResultVo(ErrorCode.SUCCESS);
    }

    @PostMapping("/login")
    public ResultVo<?> memberLogin(@RequestBody MemberVo memberVo, HttpSession session) {
        LoginResultVo lrv = memberService.loginMember(memberVo);

        if (lrv.getLoginSuccess()) {
            session.setAttribute(SessionKeys.LOGIN_ID_INFO, new MemberForSessionVo(lrv.getMemberVo()));
            ResultVo<LoginResultVo> resultVo = new ResultVo<>();

            LoginResultVo loginResultVo = new LoginResultVo();
            loginResultVo.setLoginSuccess(lrv.getLoginSuccess());
            loginResultVo.setId(memberVo.getId());

            return makeResultVo(ErrorCode.SUCCESS,loginResultVo);
        } else {
            return makeResultVo(ErrorCode.LOGIN_FAILED);
        }
    }

    @GetMapping("/emailDuplicatedCheck")
    public ResultVo<?> emailDuplicatedCheck(@RequestParam String email) {

        Boolean result = memberService.emailDuplicatedCheck(email);
        return makeResultVo(ErrorCode.SUCCESS,result);
    }

    @GetMapping("/detail")
    public ResultVo<?> memberDetailPage(@RequestParam Long id){
        MemberVo memberVo = memberService.selectMemberInfoById(id);

        return makeResultVo(ErrorCode.SUCCESS,memberVo);
    }

    @GetMapping("/department")
    public ResultVo<?> departmentList(){
        List<DepartmentVo> departmentVos = memberService.selectDepartmentList();

        return makeResultVo(ErrorCode.SUCCESS,departmentVos);
    }

    @PostMapping("/update")
    public ResultVo<?> updateMemberInfo(@RequestBody MemberVo params){
        if (params.getState().equals("")) {
            params.setState(null);
        }
        memberService.updateMemberInfo(params);
        return makeResultVo(ErrorCode.SUCCESS);
    }

}
