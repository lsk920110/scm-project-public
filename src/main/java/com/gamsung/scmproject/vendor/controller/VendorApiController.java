package com.gamsung.scmproject.vendor.controller;

import com.gamsung.scmproject.common.constant.ErrorCode;
import com.gamsung.scmproject.common.vo.ResultVo;
import com.gamsung.scmproject.vendor.service.VendorService;
import com.gamsung.scmproject.vendor.vo.VendorWithMemberNameVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/vendor")
//@CrossOrigin(origins = "http://localhost:3000")
public class VendorApiController {

    @Autowired private VendorService vendorService;


    @GetMapping("/list")
    public ResultVo<?> vendorList(){

        List<VendorWithMemberNameVo> list = vendorService.selectVendorList(null);
        ResultVo<List<VendorWithMemberNameVo>> resultVo = new ResultVo<>();
        resultVo.setErrorCode(ErrorCode.SUCCESS.getCode());
        resultVo.setErrorMessage(ErrorCode.SUCCESS.getMessage());
        resultVo.setResult(list);
        return resultVo;
    }

}
