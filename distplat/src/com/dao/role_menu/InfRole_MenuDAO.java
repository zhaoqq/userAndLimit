package com.dao.role_menu;

import com.entity.Role_MenuEntity;

import java.util.List;

public interface InfRole_MenuDAO {
    int save(Role_MenuEntity role_Menu);
    void delete(Role_MenuEntity role_Menu);
    void delete(Integer id);
    void update(Role_MenuEntity role_Menu);
    List<Role_MenuEntity> showAll();
    List<Role_MenuEntity> searchByProperty(String propertyName, Object value);
    Role_MenuEntity searchById(Integer id);
    List<Role_MenuEntity> searchByRoleId(Integer role_id);
    List<Role_MenuEntity> searchByMenuId(Integer menu_id);
    List<Role_MenuEntity> search(Role_MenuEntity role_Menu);
    int countRole_Menu();
}
