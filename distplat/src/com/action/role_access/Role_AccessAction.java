package com.action.role_access;

import com.biz.role_access.Role_AccessBiz;
import com.entity.Role_AccessEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Component("r_l_Action")
public class Role_AccessAction extends ActionSupport {
    @Resource(name = "roleAccessBiz")
    private Role_AccessBiz roleAccessBiz;

    private Role_AccessEntity limit;
    public Role_AccessEntity getLimit() {
        return limit;
    }
    public void setLimit(Role_AccessEntity limit) {
        this.limit = limit;
    }

    int id;
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }

    //添加权限
    public String addLimit() throws Exception{
        return "false";
    }

    //列出权限
    public String showAll() throws  Exception{
//        List<Role_AccessEntity>  list= roleAccessBiz.showAll();
//        Map request = (Map) ActionContext.getContext().get("request");//错误信息存request
//        request.put("ALLLimit",list);
//        if(list != null)
//            return "success";
        return "error";
    }

    //修改权限信息
    public String updateLimit() throws Exception{

//        if(roleAccessBiz.updateLimit(limit))
//            return "success";
        return "error";
    }
    //删除权限
    public String deleteLimit() throws Exception{
//        Role_AccessEntity TLimit = roleAccessBiz.queryLimit(id);
//        if(roleAccessBiz.deleteLimit(TLimit))
//            return "success";
        return "error";
    }
    //查询指定ID权限
    public String queryLimitById()throws  Exception{

//        Role_AccessEntity limit =  roleAccessBiz.queryLimit(id);
//        Map request = (Map) ActionContext.getContext().get("request");
//        request.put("Limit",limit);
        return "success";
    }
}
