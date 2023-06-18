package com.gamsung.scmproject.menubar.vo;

import lombok.Data;

@Data
public class MenubarUpdateV2ParamVo {
    private Long id;
    private String menuTitle;
    private String menuLink;
    private String position;
    private String state;
    private int orderSeq;


}
