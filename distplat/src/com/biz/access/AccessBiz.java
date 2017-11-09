package com.biz.access;
import com.dao.access.AccessDAO;
import com.dao.algo.AlgoDAO;
import com.dao.dataset.DatasetDAO;
import com.entity.AccessEntity;
import com.entity.AlgorithmEntity;
import com.entity.DatasetEntity;
import com.entity.Role_AccessEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("accessBiz")
@Scope("prototype")
@Transactional
public class AccessBiz implements InfAccessBiz {
    @Resource(name = "accessDao")
    private AccessDAO accessDAO;
    @Autowired
    private AlgoDAO algoDAO;
    @Autowired
    private DatasetDAO datasetDAO;


    //增加权限
    public boolean addLimit(AccessEntity limit){
        //判断权限名是否已占用
        if(accessDAO.searchByName(limit.getName()) == null){
            //未占用，则进行添加
            if(accessDAO.save(limit) != -1)
                return true;
        }
        //已占用，则返回重新填写信息
        return false;
    }
    //删除权限
    public boolean deleteLimit(AccessEntity limit){
        accessDAO.delete(limit);
        if(accessDAO.search(limit).size() == 0) {
            return true;
        }
        return false;
    }
    //更改权限信息
    public boolean updateLimit(AccessEntity limit){
        System.out.println(limit);

        if(limit.getAlgo() != null) {
            AlgorithmEntity algo = algoDAO.searchById(limit.getAlgo().getId());

            limit.setAlgo(algo);
        }

        if(limit.getData() != null) {
            DatasetEntity data = datasetDAO.searchById(limit.getData().getId());
            limit.setData(data);
        }

        System.out.println(limit);
        accessDAO.update(limit);
        //System.out.println(limit);
        if(accessDAO.search(limit).equals(limit)){
            return true;
        }
        return false;
    }

    //查询指定ID权限信息
    public AccessEntity queryLimit(int id){
        return accessDAO.searchById(id);
    }

    //查询全部权限信息
    public List<AccessEntity> showAll(){
        return accessDAO.showAll();
    }

    public List<AlgorithmEntity> showAllAlgos(){
        return algoDAO.showAll();
    }

    public List<DatasetEntity> showAllDatas(){
        return datasetDAO.showAll();
    }
}
