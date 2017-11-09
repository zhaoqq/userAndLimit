package com.dao.role;

import com.entity.RoleEntity;

import java.util.List;

public interface InfRoleDAO {
    int save(RoleEntity role);
    void delete(RoleEntity role);
    void delete(Integer id);
    void update(RoleEntity role);
    List<RoleEntity> showAll();
    List<RoleEntity> searchByProperty(String propertyName, Object value);
    RoleEntity searchById(Integer id);
    RoleEntity searchByName(String name);
    List<RoleEntity> search(RoleEntity role);
    int countRole();
}
