package com.gamsung.scmproject.vendor.service.impl;

import com.gamsung.scmproject.vendor.vo.VendorVo;
import com.gamsung.scmproject.vendor.mapper.VendorMapper;
import com.gamsung.scmproject.vendor.service.VendorService;
import com.gamsung.scmproject.vendor.vo.VendorWithMemberNameVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired private VendorMapper vendorMapper;

    @Override
    public void insertVendorInfo(VendorVo params) {
        params.setRegMemberId(params.getLoginId());
        params.setState("1");
        params.setRegDt(LocalDateTime.now().toString());
        vendorMapper.insertVendorInfo(params);
    }

    @Override
    public List<VendorWithMemberNameVo> selectVendorList(String state) {
        return vendorMapper.selectVendorList(state);
    }
}
