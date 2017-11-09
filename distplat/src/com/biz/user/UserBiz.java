package com.biz.user;

import com.dao.role_access.Role_AccessDAO;
import com.dao.role_user.Role_UserDAO;
import com.dao.user.UserDAO;
import com.entity.Role_UserEntity;
import com.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Benliang Wang on 2017/7/8.
 */
@Component("userBiz")
@Service("userBiz")
@Scope("prototype")
@Transactional
public class UserBiz implements InfUserBiz {
    @Resource(name = "userDAO")
    private UserDAO userDAO;
    @Autowired
    private Role_UserDAO role_userDAO;

    //登录方法
    @Override
    public List login(UserEntity condition)
    {
        return userDAO.search(condition);
    }

    //注册方法
    public boolean register(UserEntity condition){
        //判断用户是否已存在
        if(userDAO.searchByUsername(condition.getUsername()) == null){
            //不存在，则进行注册
            return userDAO.save(condition) == -1 ? false : true;
        }
        //存在，则返回重新填写信息
        return false;
    }
    //增加用户
    public boolean addUser(UserEntity user){
        //判断用户名是否已占用
        if(userDAO.searchByUsername(user.getUsername()) == null){
            //未占用，则进行注册
            if(userDAO.save(user) != -1)
                return true;
        }
        //已占用，则返回重新填写信息
        return false;
    }
    //删除用户
    public boolean deleteUser(UserEntity user){
        userDAO.delete(user);
        if(userDAO.search(user).size() == 0) {
            return true;
        }
        return false;
    }
    //更改用户信息
    public boolean updateUser(UserEntity user){
        System.out.println(user.getId());
        userDAO.update(user);
        System.out.println(user.getUsername());
        if(userDAO.search(user).equals(user)){
            return true;
        }
        return false;
    }
    //查询指定用户信息
    public List queryUser(UserEntity user){
        return userDAO.search(user);
    }
    //按ID查询
    public UserEntity queryUser(int id){
        return userDAO.searchById(id);
    }

    //查询全部用户信息
    public List showAll(){
        return userDAO.showAll();
    }


    public List<Role_UserEntity> showUserRoles(Integer id) {
        return role_userDAO.searchByUserId(id);
    }

    public boolean grantRole(Integer user_id, List<Integer> role_ids) {
        List<Role_UserEntity> list =  role_userDAO.searchByUserId(user_id);//数据库中已有的“用户-角色对”
        List<Integer> userrole_ids = new ArrayList<>();//当前角色已有的角色
        for(Role_UserEntity role_userEntity : list){
            userrole_ids.add(role_userEntity.getRole_id());
        }
        for(Integer ids : userrole_ids) {
            System.out.println("ids=="+ids);
        }


        for(int i = 0; i < role_ids.size(); i++) {//添加新用户--角色对
            Role_UserEntity userRole = new Role_UserEntity();
            if(!userrole_ids.contains(role_ids.get(i))) {
                userRole.setRole_id(role_ids.get(i));
                userRole.setUser_id(user_id);
                role_userDAO.save(userRole);
            }
        }

        System.out.println("size="+userrole_ids.size());
        for(int i = 0;i < userrole_ids.size(); i++){//删除旧的用户--角色对
            System.out.println("id="+userrole_ids.get(i));
            if(!role_ids.contains(userrole_ids.get(i))){
                Role_UserEntity userRole = role_userDAO.searchByUserIdAndRoleId(user_id, userrole_ids.get(i));
                System.out.println("delete:" + userRole.getId());
                role_userDAO.delete(userRole.getId());
            }
        }
        return true;
    }
}
