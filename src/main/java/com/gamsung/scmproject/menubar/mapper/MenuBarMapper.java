package com.gamsung.scmproject.menubar.mapper;

import com.gamsung.scmproject.menubar.vo.MenubarInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@Mapper
public interface MenuBarMapper {
    int insertManuBar(MenubarInfoVo params);

    List<MenubarInfoVo> selectMenubar(@Qualifier("position") String position);

    List<MenubarInfoVo> selectMenubarAllForManagement();

    void updateMenuBar(MenubarInfoVo params);
}
