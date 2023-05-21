package com.gamsung.scmproject.member.controller;

import com.gamsung.scmproject.common.constant.SessionKeys;
import com.gamsung.scmproject.common.vo.DepartmentVo;
import com.gamsung.scmproject.common.vo.ResultVo;
import com.gamsung.scmproject.member.service.MemberService;
import com.gamsung.scmproject.member.vo.LoginResultVo;
import com.gamsung.scmproject.member.vo.MemberForSessionVo;
import com.gamsung.scmproject.member.vo.MemberVo;
import com.gamsung.scmproject.menubar.service.MenuBarService;
import com.gamsung.scmproject.menubar.vo.MenubarInfoVo;
import com.gamsung.scmproject.menubar.vo.MenubarSideAndHeaderVo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MemberController {


    @Autowired
    private MemberService memberService;
    @Autowired
    private MenuBarService menuBarService;

    //회원 등록 페이지

    //회원 리스트 가져오기

    @GetMapping(value = "/member")
    public String memberManagement(Model model) {
        MenubarSideAndHeaderVo menubars = menuBarService.selectMenubarAll();
//        List<MenubarInfoVo> list = menuBarService.selectMenubarAllForManagement();
        model.addAttribute(SessionKeys.SIDEBAR, menubars.getSidebarList());
        model.addAttribute(SessionKeys.HEADER, menubars.getHeaderList());

        List<DepartmentVo> departmentList = memberService.selectDepartmentList();
        model.addAttribute("departmentList", departmentList);
        List<MemberVo> memberList = memberService.selectMemberList();
        model.addAttribute("memberList", memberList);
        return "member/member-management";
    }

    @PostMapping("/member/join")
    public String memberJoinModel(@ModelAttribute MemberVo memberVo) {
        memberService.joinMember(memberVo);
        return "redirect:/member";
    }

    //회원가입
    @PostMapping("/api/member/join")
    @ResponseBody
    public ResultVo memberJoinApi(@RequestBody MemberVo memberVo) {
        memberService.joinMember(memberVo);

        return ResultVo.successResult();
    }

    @PostMapping("/api/member/login")
    @ResponseBody
    public ResultVo<?> memberLogin(@RequestBody MemberVo memberVo, HttpSession session) {
        LoginResultVo lrv = memberService.loginMember(memberVo);

        if (lrv.getLoginSuccess()) {
            session.setAttribute(SessionKeys.LOGIN_ID_INFO, new MemberForSessionVo(memberVo));
            ResultVo<LoginResultVo> resultVo = new ResultVo<>();

            LoginResultVo loginResultVo = new LoginResultVo();
            loginResultVo.setLoginSuccess(lrv.getLoginSuccess());
            loginResultVo.setId(memberVo.getId());

            resultVo.setErrorCode("0000");
            resultVo.setErrorMessage("success");
            resultVo.setResult(loginResultVo);
//            resultVo.setResult();
            return resultVo;
        } else {
            return ResultVo.failedLogin();
        }
    }

    @GetMapping("/api/member/emailDuplicatedCheck")
    @ResponseBody
    public ResultVo<?> emailDuplicatedCheck(@RequestParam String email) {

        Boolean result = memberService.emailDuplicatedCheck(email);
        ResultVo<Boolean> resultVo = (ResultVo<Boolean>) ResultVo.successResult();
        resultVo.setResult(result);

        return resultVo;
    }

    @GetMapping("/login")
    public String loginPage() {


        return "loginPage";
    }


}
