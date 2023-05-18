package com.gamsung.scmproject.Navbar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuBarController {

    @GetMapping("menubar/management")
    public ModelAndView menuManagementForm(){

        return new ModelAndView("menu-management-form");
    }


}
