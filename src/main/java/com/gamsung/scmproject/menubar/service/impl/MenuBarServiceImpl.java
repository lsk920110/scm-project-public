package com.gamsung.scmproject.menubar.service.impl;

import com.gamsung.scmproject.menubar.mapper.MenuBarMapper;
import com.gamsung.scmproject.menubar.service.MenuBarService;
import com.gamsung.scmproject.menubar.vo.MenubarInfoVo;
import com.gamsung.scmproject.menubar.vo.MenubarSideAndHeaderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuBarServiceImpl implements MenuBarService {

    @Autowired
    private MenuBarMapper menuBarMapper;

    @Override
    public void insertMenuBar(MenubarInfoVo params) {
        int row = menuBarMapper.insertManuBar(params);
    }

    @Override
    public MenubarSideAndHeaderVo selectMenubarAll() {
        MenubarSideAndHeaderVo menubars = new MenubarSideAndHeaderVo();
        menubars.setSidebarList(menuBarMapper.selectMenubar("1"));
        menubars.setHeaderList(menuBarMapper.selectMenubar("2"));
        return menubars;
    }

    @Override
    public List<MenubarInfoVo> selectSideMenubarAll() {
        return menuBarMapper.selectMenubar("1");
    }

    @Override
    public List<MenubarInfoVo> selectHeaderMenubarAll() {
        return menuBarMapper.selectMenubar("2");
    }

    @Override
    public List<MenubarInfoVo> selectMenubarAllForManagement(String position) {

        return menuBarMapper.selectMenubarAllForManagement(position);
    }

    @Override
    public void updateMenuBar(MenubarInfoVo params) {
        menuBarMapper.updateMenuBar(params);
    }

    @Override
    public void updateMenuOrderSeq(List<Long> menuIdList) {
        int cnt = 1;
        for(Long menuId : menuIdList){
            menuBarMapper.updateMenuOrderSeq(menuId , cnt);
            cnt ++;
        }
    }

    @Override
    public void deleteMenu(Long menuId) {
        menuBarMapper.deleteMenu(menuId);
    }
}
