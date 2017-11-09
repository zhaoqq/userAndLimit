package com.biz.role_access;

import com.dao.role_access.Role_AccessDAO;
import com.entity.Role_AccessEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("roleAccessBiz")
@Scope("prototype")
@Transactional
public class Role_AccessBiz implements InfRole_AccessBiz {
    @Resource(name = "role_accessDao")
    private Role_AccessDAO roleAccessDAO;

//    //增加权限
//    public boolean addLimit(Role_AccessEntity limit){
//        //判断权限名是否已占用
//        if(roleAccessDAO.searchByName(limit.getName()) == null){
//            //未占用，则进行添加
//            if(roleAccessDAO.save(limit) != -1)
//                return true;
//        }
//        //已占用，则返回重新填写信息
//        return false;
//    }
//    //删除权限
//    public boolean deleteLimit(Role_AccessEntity limit){
//        roleAccessDAO.delete(limit);
//        if(roleAccessDAO.search(limit).size() == 0) {
//            return true;
//        }
//        return false;
//    }
//    //更改权限信息
//    public boolean updateLimit(Role_AccessEntity limit){
//        System.out.println(limit.getId());
//        roleAccessDAO.update(limit);
//        //System.out.println(limit);
//        if(roleAccessDAO.search(limit).equals(limit)){
//            return true;
//        }
//        return false;
//    }
//
//    //查询指定ID权限信息
//    public Role_AccessEntity queryLimit(int id){
//        return roleAccessDAO.searchById(id);
//    }
//
//    //查询全部权限信息
//    public List<Role_AccessEntity> showAll(){
//        return roleAccessDAO.showAll();
//    }
}
