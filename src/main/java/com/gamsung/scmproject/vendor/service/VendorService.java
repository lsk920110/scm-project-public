package com.gamsung.scmproject.vendor.service;

import com.gamsung.scmproject.vendor.vo.VendorVo;
import com.gamsung.scmproject.vendor.vo.VendorWithMemberNameVo;

import java.util.List;

public interface VendorService {
    void insertVendorInfo(VendorVo params);

    List<VendorWithMemberNameVo> selectVendorList(String state);
}
