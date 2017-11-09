package com.dao.role_user;

import com.entity.Role_UserEntity;
import java.util.List;

public interface InfRole_UserDAO {
    int save(Role_UserEntity role_User);
    void delete(Role_UserEntity role_User);
    void delete(Integer id);
    void update(Role_UserEntity role_User);
    List<Role_UserEntity> showAll();
    List<Role_UserEntity> searchByProperty(String propertyName, Object value);
    Role_UserEntity searchById(Integer id);
    List<Role_UserEntity> searchByRoleId(Integer role_id);
    List<Role_UserEntity> searchByUserId(Integer user_id);
    Role_UserEntity searchByUserIdAndRoleId(Integer userId, Integer roleId);
    List<Role_UserEntity> search(Role_UserEntity role_User);
    int countRole_User();
}

