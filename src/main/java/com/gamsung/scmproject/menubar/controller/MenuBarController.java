package com.gamsung.scmproject.menubar.controller;

import com.gamsung.scmproject.menubar.service.MenuBarService;
import com.gamsung.scmproject.menubar.vo.MenubarInfoVo;
import com.gamsung.scmproject.menubar.vo.MenubarSideAndHeaderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MenuBarController {

    @Autowired
    private MenuBarService menuBarService;

    @GetMapping("/menubar/management")
    public ModelAndView menuManagementForm(){
        MenubarSideAndHeaderVo menubars = menuBarService.selectMenubarAll();

        ModelAndView mav = new ModelAndView("menu-management-form");
        mav.addObject("sidebar",menubars.getSidebarList());
        mav.addObject("header",menubars.getHeaderList());
        return mav;
    }

    @PostMapping("/menubar/registration")
    public String menubarRegistration(@ModelAttribute MenubarInfoVo params){

        menuBarService.insertMenuBar(params);

        return "redirect:/menubar/management";
    }




}
