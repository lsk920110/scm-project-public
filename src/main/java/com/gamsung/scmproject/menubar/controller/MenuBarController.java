package com.gamsung.scmproject.menubar.controller;

import com.gamsung.scmproject.common.controller.BaseController;
import com.gamsung.scmproject.common.vo.ResultVo;
import com.gamsung.scmproject.menubar.service.MenuBarService;
import com.gamsung.scmproject.menubar.vo.MenubarInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MenuBarController extends BaseController {

    @Autowired
    private MenuBarService menuBarService;

    @GetMapping("/menubar/management")
    public ModelAndView menuManagementForm(){
//        MenubarSideAndHeaderVo menubarList = menuBarService.selectMenubarAll();
        List<MenubarInfoVo> menubars = menuBarService.selectMenubarAllForManagement();
        ModelAndView mav = new ModelAndView("menubar/menu-management-form");
        mav.addObject("menubars",menubars);
        menuBarInfo(mav);
//        mav.addObject(SessionKeys.HEADER,menubarList.getHeaderList());
//        mav.addObject(SessionKeys.SIDEBAR,menubarList.getSidebarList());
        return mav;
    }

    @PostMapping("/menubar/registration")
    public String menubarRegistration(@ModelAttribute MenubarInfoVo params){

        menuBarService.insertMenuBar(params);

        return "redirect:/menubar/management";
    }

    @PutMapping("/menubar/update")
    @ResponseBody
    public ResultVo<?> menubarUpdate(@RequestBody MenubarInfoVo params){
        menuBarService.updateMenuBar(params);
        ResultVo<Object> resultVo = new ResultVo<>();
        resultVo.setErrorCode("0000");
        resultVo.setErrorMessage("success");

        return resultVo;
    }




}