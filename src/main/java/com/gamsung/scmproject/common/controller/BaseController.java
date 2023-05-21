package com.gamsung.scmproject.common.controller;

import com.gamsung.scmproject.common.constant.SessionKeys;
import com.gamsung.scmproject.menubar.service.MenuBarService;
import com.gamsung.scmproject.menubar.vo.MenubarInfoVo;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class BaseController {


    @Autowired private MenuBarService menuBarService;

    public void menuBarInfo(ModelAndView mav){
        List<MenubarInfoVo> header = menuBarService.selectHeaderMenubarAll();
        List<MenubarInfoVo> sidebar = menuBarService.selectSideMenubarAll();
        mav.addObject(SessionKeys.HEADER,header);
        mav.addObject(SessionKeys.SIDEBAR,sidebar);
    }

    public void menuBarInfo(Model model){
        List<MenubarInfoVo> header = menuBarService.selectHeaderMenubarAll();
        List<MenubarInfoVo> sidebar = menuBarService.selectSideMenubarAll();
        model.addAttribute(SessionKeys.HEADER,header);
        model.addAttribute(SessionKeys.SIDEBAR,sidebar);
    }

}
