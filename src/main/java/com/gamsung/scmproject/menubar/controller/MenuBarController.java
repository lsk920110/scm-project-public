package com.gamsung.scmproject.menubar.controller;

import com.gamsung.scmproject.common.controller.BaseController;
import com.gamsung.scmproject.common.vo.ResultVo;
import com.gamsung.scmproject.menubar.service.MenuBarService;
import com.gamsung.scmproject.menubar.vo.MenuIdListVo;
import com.gamsung.scmproject.menubar.vo.MenuIdVo;
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
    public ModelAndView menuManagementForm(@RequestParam(defaultValue = "1" , required = false) String position){
//        MenubarSideAndHeaderVo menubarList = menuBarService.selectMenubarAll();
        List<MenubarInfoVo> menubars = menuBarService.selectMenubarAllForManagement(position);
        ModelAndView mav = new ModelAndView("menubar/menu-management-form");
        mav.addObject("menubars",menubars);
        mav.addObject("position",position);
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

    @PostMapping("/api/menubar/orderSeq")
    @ResponseBody
    public ResultVo<?> menubarSeqUpdate(@RequestBody MenuIdListVo params){

        menuBarService.updateMenuOrderSeq(params.getMenuIdList());
        ResultVo<Object> resultVo = new ResultVo<>();
        resultVo.setErrorCode("0000");
        resultVo.setErrorMessage("success");

        return resultVo;
    }

    @PostMapping("/api/menubar/delete")
    @ResponseBody
    public ResultVo<?>menubarDelete(@RequestBody MenuIdVo params){

        menuBarService.deleteMenu(params.getMenuId());

        ResultVo<Object> resultVo = new ResultVo<>();
        resultVo.setErrorCode("0000");
        resultVo.setErrorMessage("success");

        return resultVo;
    }




}