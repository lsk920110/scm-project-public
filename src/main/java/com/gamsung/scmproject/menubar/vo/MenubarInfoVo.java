package com.gamsung.scmproject.menubar.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MenubarInfoVo {

    private Long id;
    private String menuTitle;

    private String link;

    //1.sidebar , 2.header
    private String position;

    private String state;


}
