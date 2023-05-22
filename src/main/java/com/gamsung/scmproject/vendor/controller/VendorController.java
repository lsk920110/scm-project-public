package com.gamsung.scmproject.vendor.controller;

import com.gamsung.scmproject.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VendorController extends BaseController {


    @GetMapping("/vendor/management")
    public String vendorManagement(Model model){
        menuBarInfo(model);

        return "vendor/vendor-form";
    }


}
