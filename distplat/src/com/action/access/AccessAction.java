package com.action.access;

import com.biz.access.AccessBiz;
import com.entity.AccessEntity;
import com.entity.AlgorithmEntity;
import com.entity.DatasetEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Component("lAction")
public class AccessAction extends ActionSupport {
    @Resource(name = "accessBiz")
    private AccessBiz accessBiz;

    private AccessEntity limit;
    public AccessEntity getLimit() {
        return limit;
    }
    public void setLimit(AccessEntity limit) {
        this.limit = limit;
    }

    private int id;
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }

    //添加权限
    public String addLimit() throws Exception {
        limit.setName(new String(limit.getName().getBytes("GBK"), "UTF-8"));
        limit.setComment(new String(limit.getComment().getBytes("GBK"), "UTF-8"));
        System.out.println(limit.getAlgo());
        System.out.println(limit.getData());
        if (accessBiz.addLimit(limit)) {
            return "success";
        }
        Map request = (Map) ActionContext.getContext().get("request");//错误信息存request
        request.put("LIMITNAME", limit.getName() + "权限名已存在");
        return "error";
    }

    //列出权限
    public String showAll() throws Exception {
        List<AccessEntity> list = accessBiz.showAll();
        Map request = (Map) ActionContext.getContext().get("request");//错误信息存request
        request.put("ALLLimit", list);
        if (list != null)
            return "success";
        return "error";
    }

    //修改权限信息
    public String updateLimit() throws Exception {
        AccessEntity edit_limit = accessBiz.queryLimit(id);
        if (limit.getName() == null || limit.getName().equals("")) {
            limit.setName(edit_limit.getName());
        } else {
            limit.setName(new String(limit.getName().getBytes("GBK"), "UTF-8"));
        }
        if (limit.getComment() == null || limit.getComment().equals("")) {
            limit.setComment(edit_limit.getComment());
        } else {
            limit.setComment(new String(limit.getComment().getBytes("GBK"), "UTF-8"));
        }
        if(limit.getLimits() == null || limit.getLimits().equals("")){
            limit.setLimits(edit_limit.getLimits());
        }

        System.out.println(this.limit);
        if (accessBiz.updateLimit(limit))
            return "success";
        return "error";
    }

    //删除权限
    public String deleteLimit() throws Exception {
        AccessEntity TLimit = accessBiz.queryLimit(id);
        if (accessBiz.deleteLimit(TLimit))
            return "success";
        return "error";
    }

    //查询指定ID权限
    public String queryLimitById() throws Exception {
        AccessEntity limit = accessBiz.queryLimit(id);
        if(limit != null) {
            Map request = (Map) ActionContext.getContext().get("request");
            request.put("Limit", limit);
            return "success";
        }
        return "error";
    }

    //显示可选的数据，算法进行分配权限
    public String showAllAlgoData() throws Exception{
        List<AlgorithmEntity> algos = accessBiz.showAllAlgos();
        List<DatasetEntity> datas = accessBiz.showAllDatas();

        Map request = (Map) ActionContext.getContext().get("request");
        request.put("Algos", algos);
        request.put("Datas", datas);
        //request.put("id", id);
        return "success";
    }
}
