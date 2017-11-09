package com.action.user;

import com.biz.role.InfRoleBiz;
import com.biz.role.RoleBiz;
import com.biz.user.UserBiz;
import com.entity.RoleEntity;
import com.entity.Role_UserEntity;
import com.entity.UserEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Component("uAction")
@Scope("prototype")
public class UserAction extends ActionSupport {
    private HttpSession session;
    private HttpServletRequest request;

    @Resource(name = "userBiz")//属于J2EE的，按照名称空间注入
    private UserBiz userBiz;
    @Resource(name = "roleBiz")
    private InfRoleBiz roleBiz;



    UserEntity user;
    public void setUser(UserEntity user) {
        this.user= user;
    }
    public UserEntity getUser() {
        return this.user;
    }

    int id;
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }

    private List<Integer> userRoles;
    public List<Integer> getUserRoles() {
        return userRoles;
    }
    public void setUserRoles(List<Integer> userRoles) {
        this.userRoles = userRoles;
    }


    public String register() throws  Exception {
        user.setComment(new String(user.getComment().getBytes("GBK"),"UTF-8"));
        //user.setComment(comment);
        System.out.println(user.getComment());//测试输出的描述是否正确
        if(userBiz.register(user) == true) {
            return "success";
        }else{
            //提示用户名已注册的信息到request域中
//            HttpServletRequest req = ServletActionContext.getRequest();
//            req.setAttribute("USERNAME", user.getUsername()+"用户名已存在");
            Map request = (Map) ActionContext.getContext().get("request");//错误信息存request
            request.put("USERNAME",user.getUsername()+"用户名已存在");
            return "error";
        }
    }

    public String login()throws  Exception{
        //System.out.println(user);
        int result = userBiz.login(user).size();
        if(result>0) {
            ActionContext actionContext = ActionContext.getContext();
            Map session = actionContext.getSession();
            session.put("CurrentUser", user);
            return "success";
        } else{
            Map request = (Map) ActionContext.getContext().get("request");//错误信息存request
            request.put("INFO","用户名或密码错误！");
            return "error";
        }
    }

    public String showAll()throws  Exception{
        List list = userBiz.showAll();

        Map request = (Map) ActionContext.getContext().get("request");//这个Struts2 里的request也可以实现
        request.put("test", "request");
        request.put("ALLUser",list);
        return "success";
    }

    public String deleteUser()throws Exception{
        UserEntity Tuser = userBiz.queryUser(id);
        if(userBiz.deleteUser(Tuser)){
            return "success";
        }
        return "error";
    }

    public String updateUser()throws Exception{
        user.setComment(new String(user.getComment().getBytes("GBK"),"UTF-8"));
        UserEntity edit_user = userBiz.queryUser(user.getId());
        if(user.getUsername() == null || user.getUsername().equals("")) {
            user.setUsername(edit_user.getUsername());
        }
        if(user.getEmail() == null || user.getEmail().equals("")) {
            user.setEmail(edit_user.getEmail());
        }
        if(user.getComment() == null || user.getComment().equals("")) {
            user.setComment(edit_user.getComment());
        }
        System.out.println(user);
        if(userBiz.updateUser(user))
            return "success";
        else
            return "error";
    }

    //查询指定ID者
    public String queryById()throws Exception{
        UserEntity User =  userBiz.queryUser(id);
        Map request = (Map) ActionContext.getContext().get("request");
        request.put("User",User);
        return "success";
    }

    public String logout() throws Exception{
        this.request = ServletActionContext.getRequest();
        this.session = this.request.getSession();
        session.invalidate();
        return "success";
    }

    //已有角色查询结果回显
    public String grantRole() throws Exception {
        System.out.println(id);
        List<RoleEntity> roles = roleBiz.showAll();
        List<Role_UserEntity> user_roles = userBiz.showUserRoles(id);

        Map request = (Map) ActionContext.getContext().get("request");
        request.put("roles", roles);
        request.put("user_roles", user_roles);
        request.put("id", id);


        return "success";
    }

    public String allotRole() throws Exception {
        //System.out.println(id);
        System.out.println(userRoles.size());
        for (int i=0; i<userRoles.size(); i++)
            System.out.println(userRoles.get(i));
        if(userBiz.grantRole(id, userRoles))
            return "success";
        return "error";
    }


}
