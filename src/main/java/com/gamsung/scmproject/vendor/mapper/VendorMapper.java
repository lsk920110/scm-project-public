package com.gamsung.scmproject.vendor.mapper;

import com.gamsung.scmproject.vendor.vo.VendorVo;
import com.gamsung.scmproject.vendor.vo.VendorWithMemberNameVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VendorMapper {
    void insertVendorInfo(VendorVo params);

    List<VendorWithMemberNameVo> selectVendorList(String state);
}
