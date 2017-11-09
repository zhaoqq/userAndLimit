package com.dao.access;

import com.entity.AccessEntity;
import java.util.List;


public interface InfAccessDAO {
    int save(AccessEntity access);
    void delete(AccessEntity access);
    void delete(Integer id);
    void update(AccessEntity access);
    List<AccessEntity> showAll();
    List<AccessEntity> searchByProperty(String propertyName, Object value);
    AccessEntity searchById(Integer id);
    AccessEntity searchByName(String name);
//    List<AccessEntity> searchByRoleId(Integer role_id);
    List<AccessEntity> searchByDataId(Integer data_id);
    List<AccessEntity> searchByAlgoId(Integer algo_id);
    List<AccessEntity> search(AccessEntity access);
    //int countRole_Access();
    int countData_Access();
    int countAlgo_Access();
}

