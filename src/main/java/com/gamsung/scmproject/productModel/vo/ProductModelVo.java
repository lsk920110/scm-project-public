package com.gamsung.scmproject.productModel.vo;

import com.gamsung.scmproject.member.vo.AuthIf;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter @ToString
public class ProductModelVo implements AuthIf {


    private Long id;
    private Long productCategoryId;
    private String modelCord;
    private Long stock;
    private LocalDateTime regDt;
    private String productStatus;
    private Long memberId;





    @Override
    public Long getLoginId() {
        return this.memberId;
    }

    @Override
    public void setLoginId(Long loginId) {
        this.memberId = loginId;
    }
}
