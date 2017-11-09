package com.action.user;

import com.biz.user.UserBiz;
import com.entity.UserEntity;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("umAction")
public class UserManagerAction extends ActionSupport
{
    private String loginName;
    private String loginPwd;

    public void setLoginName(String loginName)
    {
        this.loginName = loginName;
    }

    public String getLoginName()
    {
        return loginName;
    }

    public void setLoginPwd(String loginPwd)
    {
        this.loginPwd = loginPwd;
    }

    public String getLoginPwd()
    {
        return loginPwd;
    }
    @Autowired
    UserBiz userBiz;

    public void setUserBiz(UserBiz userBiz)
    {
        this.userBiz = userBiz;
    }

    @Override
    public String execute() throws  Exception
    {
        UserEntity condition = new UserEntity();
        condition.setUsername(loginName);
        condition.setPassword(loginPwd);

        List list = userBiz.login(condition);

        if(list.size() > 0)
        {
            return  "success";
        } else
        {
            return "error";
        }
    }



    public String addUser() throws  Exception
    {
        return null;
    }
    public String deleteUser() throws  Exception
    {
        return null;
    }
    public String updateUser() throws  Exception
    {
        return null;
    }
    public String queryUser() throws  Exception
    {
        return null;
    }
}
