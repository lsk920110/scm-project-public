package com.gamsung.scmproject.member.controller;

import com.gamsung.scmproject.common.vo.ResultVo;
import com.gamsung.scmproject.member.service.MemberService;
import com.gamsung.scmproject.member.vo.MemberForSessionVo;
import com.gamsung.scmproject.member.vo.MemberVo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MemberController {


    @Autowired
    private MemberService memberService;
    //회원 등록 페이지


    //회원 리스트 가져오기

//    @GetMapping(value="/")
//    public String main(){
//        return "blank";
//    }

    //회원가입
    @PostMapping("/api/member/join")
    @ResponseBody
    public ResultVo memberJoin(@RequestBody MemberVo memberVo){
        memberService.joinMember(memberVo);

        return ResultVo.successResult();
    }

    @PostMapping("/api/member/login")
    @ResponseBody
    public ResultVo memberLogin(@RequestBody MemberVo memberVo , HttpSession session){
        Boolean result = memberService.loginMember(memberVo);
        if(result) {
            session.setAttribute("loginIdInfo",new MemberForSessionVo(memberVo));
            return ResultVo.successResult();
        } else {
            return ResultVo.failedLogin();
        }
    }

    @GetMapping("/api/member/emailDuplicatedCheck")
    @ResponseBody
    public ResultVo emailDuplicatedCheck(@RequestParam String email){

        Boolean result = memberService.emailDuplicatedCheck(email);
        ResultVo<Boolean> resultVo = (ResultVo<Boolean>) ResultVo.successResult();
        resultVo.setResult(result);

        return resultVo;
    }





}
