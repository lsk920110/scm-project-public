package com.gamsung.scmproject.callcenter.controller;

import com.gamsung.scmproject.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CallcenterController extends BaseController {

    @RequestMapping("/callcenter")
    public String callcenterManagement(Model model){
        menuBarInfo(model);
        vendorList(model);
        return "callcenter/callcenter-management-form";
    }


}
