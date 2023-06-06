package com.gamsung.scmproject.delivery.controller;

import com.gamsung.scmproject.common.controller.BaseController;
import com.gamsung.scmproject.delivery.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeliveryController extends BaseController {

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("/delivery")
    public String deliveryForm(Model model){
        menuBarInfo(model);

        return "";
    }

    @PostMapping("/api/batch/delivery")
    public String assignDeliveryInfo(Model model){

        deliveryService.batchAssignDelivery();

        return null;
    }


}
