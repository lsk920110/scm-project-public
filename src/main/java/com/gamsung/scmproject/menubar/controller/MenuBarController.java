package com.gamsung.scmproject.menubar.controller;

import com.gamsung.scmproject.common.constant.ErrorCode;
import com.gamsung.scmproject.common.constant.ModelObjectKey;
import com.gamsung.scmproject.common.controller.BaseController;
import com.gamsung.scmproject.common.vo.ListTypeParamVo;
import com.gamsung.scmproject.common.vo.ResultVo;
import com.gamsung.scmproject.menubar.service.MenuBarService;
import com.gamsung.scmproject.menubar.vo.MenuIdListVo;
import com.gamsung.scmproject.menubar.vo.MenuIdVo;
import com.gamsung.scmproject.menubar.vo.MenubarInfoVo;
import com.gamsung.scmproject.menubar.vo.MenubarUpdateV2ParamVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class MenuBarController extends BaseController {

    @Autowired
    private MenuBarService menuBarService;

    @GetMapping("/menubar/registration")
    public ModelAndView menubarRegistration(){
        ModelAndView mav = new ModelAndView("menubar/menu-registration-form");
        menuBarInfo(mav);
        return mav;
    }

    @GetMapping("/menubar/management")
    public ModelAndView menuManagementForm(@RequestParam(defaultValue = "1" , required = false) String position){
        ModelAndView mav = new ModelAndView("menubar/menu-management-form");
        menuBarInfo(mav);

        List<MenubarInfoVo> menubars = menuBarService.selectMenubarAllForManagement(position);
        mav.addObject(ModelObjectKey.MENU_BARS,menubars);
        mav.addObject(ModelObjectKey.POSITION,position);

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
        return makeResultVo(ErrorCode.SUCCESS);
    }

    @PostMapping("/menubar/update/v2")
    @ResponseBody
    public ResultVo<?> menubarUpdateV2(@RequestBody ListTypeParamVo<MenubarUpdateV2ParamVo> params){
        log.info("{}",params);
        menuBarService.updateMenuBarV2(params);

        return makeResultVo(ErrorCode.SUCCESS);
    }

    @PostMapping("/api/menubar/orderSeq")
    @ResponseBody
    public ResultVo<?> menubarSeqUpdate(@RequestBody MenuIdListVo params){

        menuBarService.updateMenuOrderSeq(params.getMenuIdList());
        return makeResultVo(ErrorCode.SUCCESS);

    }

    @PostMapping("/api/menubar/delete")
    @ResponseBody
    public ResultVo<?>menubarDelete(@RequestBody MenuIdVo params){

        menuBarService.deleteMenu(params.getMenuId());
        return makeResultVo(ErrorCode.SUCCESS);
    }




}