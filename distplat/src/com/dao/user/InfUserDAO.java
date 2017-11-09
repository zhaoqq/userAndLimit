package com.dao.user;

import com.entity.UserEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/5/17.
 */

public interface InfUserDAO {
     int save(UserEntity user);
     void delete(UserEntity user);
     void deleteById(Integer id);
     void update(UserEntity user);
     List<UserEntity> showAll();
     List<UserEntity> searchByProperty(String propertyName, Object value);
     UserEntity searchById(Integer id);
     UserEntity searchByUsername(String username);
     List<UserEntity> search(UserEntity user);
     int countUser();
     List<UserEntity> searchByPage(int begin, int pageSize);

     //boolean isRegistered(String username);
}
