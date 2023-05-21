package com.gamsung.scmproject.main.controller;

import com.gamsung.scmproject.common.constant.SessionKeys;
import com.gamsung.scmproject.menubar.service.MenuBarService;
import com.gamsung.scmproject.menubar.vo.MenubarSideAndHeaderVo;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainDashBoardController {

    @Autowired private MenuBarService menuBarService;


    @GetMapping("/")
    public String main(HttpSession session, Model model){
        MenubarSideAndHeaderVo menubars = menuBarService.selectMenubarAll();
        model.addAttribute(SessionKeys.SIDEBAR,menubars.getSidebarList());
        model.addAttribute(SessionKeys.HEADER,menubars.getHeaderList());

        //집계와 관련한 내용들도 추가한다.

        return "main-dashboard";
    }

}
