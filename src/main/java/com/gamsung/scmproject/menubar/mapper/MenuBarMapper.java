package com.gamsung.scmproject.menubar.mapper;

import com.gamsung.scmproject.menubar.vo.MenubarInfoVo;
import com.gamsung.scmproject.menubar.vo.MenubarUpdateV2ParamVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@Mapper
public interface MenuBarMapper {
    int insertManuBar(MenubarInfoVo params);

    List<MenubarInfoVo> selectMenubar(@Qualifier("position") String position);

    List<MenubarInfoVo> selectMenubarAllForManagement(@Qualifier("position") String position);

    void updateMenuBar(MenubarInfoVo params);

    void updateMenuOrderSeq(@Qualifier("menuId") Long menuId, @Qualifier("cnt") int cnt);

    void deleteMenu(@Qualifier("menuId") Long menuId);

    void updateMenubarV2(MenubarUpdateV2ParamVo param);
}
