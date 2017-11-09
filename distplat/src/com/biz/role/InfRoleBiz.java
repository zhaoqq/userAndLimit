package com.biz.role;

import com.entity.RoleEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface InfRoleBiz {
    boolean addRole(RoleEntity role);
    List showAll();
    boolean updateRole(RoleEntity role);
    boolean deleteRole(RoleEntity role);

}
