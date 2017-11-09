package com.dao.menu;

import com.entity.MenuEntity;

import java.util.List;

public interface InfMenuDAO {
    int save(MenuEntity menu);
    void delete(MenuEntity menu);
    void delete(Integer id);
    void update(MenuEntity menu);
    List<MenuEntity> showAll();
    List<MenuEntity> searchByProperty(String propertyName, Object value);
    MenuEntity searchById(Integer id);
    MenuEntity searchByName(String name);
    List<MenuEntity> search(MenuEntity menu);
    int countMenu();
}
