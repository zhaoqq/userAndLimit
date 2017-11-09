package com.action.role;

import com.biz.role.RoleBiz;
import com.entity.AccessEntity;
import com.entity.RoleEntity;
import com.entity.Role_AccessEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Component("rAction")
public class RoleAction extends ActionSupport {
    @Resource(name = "roleBiz")
    private RoleBiz roleBiz;

    private RoleEntity role ;
    public void setRole(RoleEntity role) {
        this.role = role;
    }
    public RoleEntity getRole() {
        return role;
    }

    int id;
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }

    private List<Integer> roleLimit_ids;
    public List<Integer> getRoleLimit_ids() {
        return roleLimit_ids;
    }
    public void setRoleLimit_ids(List<Integer> roleLimit_ids) {
        this.roleLimit_ids = roleLimit_ids;
    }

    //添加角色
    public String add() throws  Exception{
        role.setName(new String(role.getName().getBytes("GBK"),"UTF-8"));
        role.setComment(new String(role.getComment().getBytes("GBK"),"UTF-8"));
        System.out.println(role.getName());
        System.out.println(role.getComment());

        if(roleBiz.addRole(role)){
            return "success";
        }
        Map request = (Map) ActionContext.getContext().get("request");//错误信息存request
        request.put("ROLENAME",role.getName()+"用户名已存在");
        return "error";
    }
    //显示全部角色
    public String showAll() throws  Exception{
        List<RoleEntity> list = roleBiz.showAll();
        Map request = (Map) ActionContext.getContext().get("request");//错误信息存request
        request.put("ALLRole",list);
        if(list != null)
            return "success";
        return "error";
    }
    //  按照指定id查询角色
    public String queryRoleById()throws  Exception{
        RoleEntity role =  roleBiz.queryRole(id);
        Map request = (Map) ActionContext.getContext().get("request");
        request.put("Role",role);
        return "success";
    }
    //更新角色信息
    public String updateRole() throws Exception{
        role.setName(new String(role.getName().getBytes("GBK"),"UTF-8"));
        role.setComment(new String(role.getComment().getBytes("GBK"),"UTF-8"));
        RoleEntity edit_role = roleBiz.queryRole(role.getId());
        if(role.getName() == null || role.getName().equals("")) {
            role.setName(new String(edit_role.getName().getBytes("GBK"),"UTF-8"));
        }
        if(role.getComment() == null || role.getComment().equals("")) {
            role.setComment(new String(edit_role.getComment().getBytes("GBK"),"UTF-8"));
        }
        if(roleBiz.updateRole(role))
            return "success";
        return "error";
    }
    //删除指定id角色
    public String deleteRole() throws Exception{
        RoleEntity Trole = roleBiz.queryRoleById(id);
        if(roleBiz.deleteRole(Trole))
            return "success";
        return "error";
    }
    //显示全部权限
    public String showAllRoleLimits() throws Exception{
        String RoleName = roleBiz.queryRoleById(id).getName();
        List<AccessEntity> list =  roleBiz.showAllLimits();//全部权限
        List<Role_AccessEntity> role_limits = roleBiz.showRoleLimits(id);//角色已有权限
       // System.out.println(role_limits.size());
        Map request = (Map) ActionContext.getContext().get("request");//错误信息存request
        request.put("ALLLimits",list);
        request.put("RoleName",RoleName);
        request.put("RoleLimits",role_limits);
        request.put("role_id",id);
        if(list.size()>0 && RoleName != null)
            return "success";
        return "error";
    }

    public String AllotLimits() throws Exception{
        //System.out.println(roleLimit_ids.size());
        //System.out.println(roleLimit_ids.get(0));
        //System.out.println("传过来的选中权限"+roleLimit_ids+"\n要分配权限的角色id"+id);
        if(roleBiz.allotLimits(id,roleLimit_ids)){

            return "success";
        }
        return "error";
    }
}
