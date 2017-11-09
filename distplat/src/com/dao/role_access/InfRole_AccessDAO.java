package com.dao.role_access;

import com.entity.AccessEntity;
import com.entity.RoleEntity;
import com.entity.Role_AccessEntity;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface InfRole_AccessDAO {
    int save(Role_AccessEntity role_Access);
    void delete(Role_AccessEntity role_Access);
    void delete(Integer id);
    void update(Role_AccessEntity role_Access);
    List<Role_AccessEntity> showAll();
    List<Role_AccessEntity> searchByProperty(String propertyName, Object value);
    Role_AccessEntity searchById(Integer id);
    Role_AccessEntity searchByRoleAndAccess(RoleEntity role_id, AccessEntity access_id);
    Role_AccessEntity searchByName(String name);
    List<Role_AccessEntity> searchByRoleId(Integer role_id);
    List<Role_AccessEntity> search(Role_AccessEntity role_Access);
    int countRole_Access();
}
