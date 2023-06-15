package com.gamsung.scmproject.menubar.service;

import com.gamsung.scmproject.menubar.vo.MenubarInfoVo;
import com.gamsung.scmproject.menubar.vo.MenubarSideAndHeaderVo;

import java.util.List;

public interface MenuBarService {

    void insertMenuBar(MenubarInfoVo params);

    MenubarSideAndHeaderVo selectMenubarAll();

    List<MenubarInfoVo> selectSideMenubarAll();

    List<MenubarInfoVo> selectHeaderMenubarAll();


    List<MenubarInfoVo> selectMenubarAllForManagement(String position);

    void updateMenuBar(MenubarInfoVo params);

    void updateMenuOrderSeq(List<Long> menuIdList);

    void deleteMenu(Long menuId);
}
