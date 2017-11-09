package com.action.algo;

import com.action.algo.MyHttpClient;
import com.dao.algo.AlgoDAO;
import com.dao.dataset.DatasetDAO;
import com.entity.AlgorithmEntity;
import com.entity.DatasetEntity;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Benliang on 2017/8/15.
 */
@Component( "runAlgorithm")
public class runAlgoAction extends ActionSupport {
    @Resource
    private AlgoDAO algoDAO;
    @Resource
    private DatasetDAO datasetDAO;

    private String yourAlgo;
    private String yourDataset;
    private List<DatasetEntity> datasets;
    private List<AlgorithmEntity> algos;
    private Map executeResult;
    private String jobId;
    public void setJobId(String jobId){
        this.jobId = jobId;
    }
    public String getJobId()
    {
        return this.jobId;
    }

    public void setExecuteResult(JSONObject executeResult)
    {
        this.executeResult = executeResult;
    }

    public Map<String, String> getExecuteResult(){
        return this.executeResult;
    }

    public void setYourAlgo(String yourAlgo)
    {
        this.yourAlgo = yourAlgo;
    }
    public String getYourAlgo(){
        return yourAlgo;
    }
    public void setYourDataset(String yourDataset)
    {
        this.yourDataset = yourDataset;
    }
    public String getYourDataset(){
        return yourDataset;
    }
    public void setAlgos() {
        this.algos = algoDAO.showAll();
    }
    public List getAlgos()
    {
        return this.algoDAO.showAll();
    }
    public void setDataSets() {
        this.datasets = datasetDAO.showAll();
    }
    public List getDataSets()
    {
        return datasetDAO.showAll();
    }
    public String getDefaultAlgo()
    {
        return "defaulalgo";
    }


    @Override
    public String execute() throws Exception {
        String spark_host = "http://10.108.17.218:8090/jobs?appName=test&classPath=spark.jobserver.WordCountExample";
        String raw_text = "input.string = a b c a b see";
        MyHttpClient client = new MyHttpClient(spark_host, raw_text);
        JSONObject res = client.postData();
        if(res != null ) {
            this.executeResult = (Map)res;
            this.jobId = res.get("jobId").toString();
            return "success";
        }
        else
        {   this.executeResult = null;
            return "error";}
    }


    public String showresult() throws IOException {
        String spark_host = "http://10.108.17.218:8090/jobs/"+this.jobId;
        MyHttpClient client = new MyHttpClient(spark_host, "");
        this.executeResult = client.getData();
        return "success";
    }
    public String display(){

        return NONE;
    }

}
