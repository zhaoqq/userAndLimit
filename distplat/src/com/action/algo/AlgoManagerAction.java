package com.action.algo;

import com.biz.algo.AlgoBiz;
import com.entity.AlgorithmEntity;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/7/8.
 */

@Component("runAlgoAction")
public class AlgoManagerAction extends ActionSupport {
    private String algo;
    private String dataset;
    public void setAlgo (String algo){this.algo = algo;}
    public void setDataset(String dataset) {this.dataset = dataset;}

    private AlgoBiz algoBiz;

    public void setAlgoBiz(AlgoBiz algoBiz) {
        this.algoBiz = algoBiz;
    }
    public AlgoBiz getAlgoBiz() {
        return algoBiz;
    }

    @Override
    public String execute() throws Exception
    {
        AlgorithmEntity con = new AlgorithmEntity();
        con.setAlName(algo);
        return "success.";
    }
}
