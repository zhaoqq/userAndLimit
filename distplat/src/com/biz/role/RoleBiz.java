package com.biz.role;

import com.dao.access.AccessDAO;
import com.dao.role_access.Role_AccessDAO;
import com.entity.AccessEntity;
import com.entity.RoleEntity;
import com.entity.Role_AccessEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dao.role.*;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component("roleBiz")
@Service("roleBiz")
@Scope("prototype")
@Transactional
public class RoleBiz implements InfRoleBiz {

    @Resource(name = "roleDAO")
    private RoleDAO roleDAO;
    @Resource(name = "accessDao")
    private AccessDAO accessDAO;
    @Resource(name = "role_accessDao")
    private Role_AccessDAO roleAccessDAO;

    //添加新角色
    public boolean addRole(RoleEntity role){
        //判断角色名是否已占用
        if(roleDAO.searchByName(role.getName()) == null){
            //未占用，则进行添加
            if(roleDAO.save(role) != -1)
                return true;
        }
        //已占用，则返回重新填写信息
        return false;
    }

    //查询所有角色
    public List showAll(){
        return roleDAO.showAll();
    }

    //更新角色信息
    public boolean updateRole(RoleEntity role){
        roleDAO.update(role);
        if(roleDAO.search(role).equals(role) )
            return true;
        return false;
    }

    //删除指定角色
    public boolean deleteRole(RoleEntity role){
        roleDAO.delete(role);
        if(roleDAO.search(role).size() == 0)
            return true;
        return false;
    }

    //按角色名称查询角色
    public boolean qureyRole(String roleName){
        //名称不存在，返回true
        if(roleDAO.searchByName(roleName) == null){
            return true;
        }
        //名称存在，返回false
        return false;
    }

    public RoleEntity queryRole(int id){
        return roleDAO.searchById(id);
    }

    public RoleEntity queryRoleById(int id){
        return roleDAO.searchById(id);
    }

    public List<AccessEntity> showAllLimits(){
        return accessDAO.showAll();
    }

    public boolean allotLimits(Integer role_id,List<Integer> roleLimit_ids){
        //要分配权限的角色
        RoleEntity role = roleDAO.searchById(role_id);

        //在角色权限表中已有的角色权限对记录
        List<Role_AccessEntity> list = roleAccessDAO.searchByProperty("role", role);

        //角色已有的权限的list
        List<AccessEntity> roleLimits = new ArrayList<>();
        for(Role_AccessEntity index :list){
            roleLimits.add(index.getAccess());
        }

        //要存储的角色权限记录对应的对象
        Role_AccessEntity role_Access = new Role_AccessEntity();
        role_Access.setRole(role);

        for(int i = 0; i < roleLimit_ids.size(); i++){
            AccessEntity access = accessDAO.searchById(roleLimit_ids.get(i));
            if(!roleLimits.contains(access)) {
                role_Access.setAccess(access);
                roleAccessDAO.save(role_Access);
            }
        }

//        System.out.println("-----------------------test---------------------------");
//
//        List li = roleAccessDAO.searchByRoleId(role.getId());
//        Role_AccessEntity ra = (Role_AccessEntity) li.get(0);
//        System.out.println("searchRole:\n"+ra);
//
//        System.out.println("-----------------------end---------------------------");

        for(int i = 0;i<roleLimits.size();i++){
            if(!roleLimit_ids.contains(roleLimits.get(i).getId())){
                //System.out.println("limit_id:"+roleLimits.get(i).getId());
                Role_AccessEntity tra = roleAccessDAO.searchByRoleAndAccess(role,roleLimits.get(i));
                //System.out.println("要删除的角色权限对的记录"+tra);
                roleAccessDAO.delete(tra.getId());
            }
        }
        return true;
    }

    public List<Role_AccessEntity> showRoleLimits(Integer id){
        return roleAccessDAO.searchByProperty("role",roleDAO.searchById(id));
    }

}
