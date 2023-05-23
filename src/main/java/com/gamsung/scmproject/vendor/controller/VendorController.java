package com.gamsung.scmproject.vendor.controller;

import com.gamsung.scmproject.common.controller.BaseController;
import com.gamsung.scmproject.vendor.vo.VendorVo;
import com.gamsung.scmproject.vendor.service.VendorService;
import com.gamsung.scmproject.vendor.vo.VendorWithMemberNameVo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class VendorController extends BaseController {

    @Autowired private VendorService vendorService;


    @GetMapping("/vendor/management")
    public String vendorManagement(Model model){
        menuBarInfo(model);
        List<VendorWithMemberNameVo> list = vendorService.selectVendorList(null);
        model.addAttribute("vendorList",list);

        return "vendor/vendor-form";
    }

    @PostMapping("/vendor/registration")
    public String vendorRegistration(@ModelAttribute VendorVo params , HttpSession session){
        sessionLoginInfo(session,params);

        vendorService.insertVendorInfo(params);


        return "redirect:/vendor/management";
    }


}
