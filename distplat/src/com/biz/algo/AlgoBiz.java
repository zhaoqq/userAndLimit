package com.biz.algo;

import com.dao.algo.AlgoDAO;
import com.entity.AlgorithmEntity;
import com.entity.DatasetEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/7/8.
 */
@Component
public class AlgoBiz implements InfAlgoBiz {
    @Autowired
    public AlgoDAO algoDAO;

    @Override
    public List showAll() {
        return algoDAO.showAll();
    }

    @Override
    public List search(AlgorithmEntity algo) {
        return null;
    }

    @Override
    public String runAlgoResult(AlgorithmEntity algo, DatasetEntity dataset)
    {

        return "success";
    }


}
