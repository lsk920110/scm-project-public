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
@RestController
@RequestMapping("/api/menubar")
public class MenuBarApiController extends BaseController {

    @Autowired
    private MenuBarService menuBarService;

    public static final String[] MENU_BAR_API_PATH = {
            "/api/menubar/management",
            "/api/menubar/registration",
            "/api/menubar/update",
            "/api/menubar/update/v2",
            "/api/menubar/orderSeq",
            "/api/menubar/delete"
    };

    @GetMapping("/management")
    public ResultVo<?> menuManagementForm(@RequestParam(defaultValue = "1" , required = false) String position){

        List<MenubarInfoVo> menubars = menuBarService.selectMenubarAllForManagement(position);
        return makeResultVo(ErrorCode.SUCCESS,menubars);
    }

    @PostMapping("/registration")
    public ResultVo<?> menubarRegistration(@ModelAttribute MenubarInfoVo params){

        menuBarService.insertMenuBar(params);

        return makeResultVo(ErrorCode.SUCCESS);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResultVo<?> menubarUpdate(@RequestBody MenubarInfoVo params){
        menuBarService.updateMenuBar(params);
        return makeResultVo(ErrorCode.SUCCESS);
    }

    @PostMapping("/update/v2")
    public ResultVo<?> menubarUpdateV2(@RequestBody ListTypeParamVo<MenubarUpdateV2ParamVo> params){
        menuBarService.updateMenuBarV2(params);
    return makeResultVo(ErrorCode.SUCCESS);
    }

    @PostMapping("/orderSeq")
    @ResponseBody
    public ResultVo<?> menubarSeqUpdate(@RequestBody MenuIdListVo params){

        menuBarService.updateMenuOrderSeq(params.getMenuIdList());
        return makeResultVo(ErrorCode.SUCCESS);

    }

    @PostMapping("/delete")
    @ResponseBody
    public ResultVo<?>menubarDelete(@RequestBody MenuIdVo params){
        menuBarService.deleteMenu(params.getMenuId());
        return makeResultVo(ErrorCode.SUCCESS);
    }




}