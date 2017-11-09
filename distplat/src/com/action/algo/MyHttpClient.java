package com.action.algo;

/**
 * Created by Benliang on 2017/8/26.
 */
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;

public class MyHttpClient implements IMyHttpClient{
    private String spark_host;
//    private String method;
//    private List<Pair> params;
    private String raw_text;
    // String method, List<Pair> params,

    public  MyHttpClient(String spark_host, String raw_text)
    {
        this.spark_host = spark_host;
//        this.method = method;
//        this.params = params;
        this.raw_text = raw_text==null?null:raw_text;
    }
    public void setSpark_host(String spark_host){
        this.spark_host = spark_host;
    }
    public void setRaw_text(String raw_text)
    {
        this.raw_text = raw_text;
    }
    public String getSpark_host (){
        return this.spark_host;
    }

    public String getRaw_text() {
        return raw_text;
    }

    public JSONObject postData() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        ResponseHandler<JSONObject> responseHandler =  new MyJSONResponseHandler();
        try {
            HttpPost httppost = new HttpPost(spark_host);
            StringEntity postString = new StringEntity(raw_text);
            httppost.setEntity(postString);
            httppost.setHeader("Content-type", "text/plain");
            JSONObject responseBody =  httpclient.execute(httppost, responseHandler);
            String duration = (String) responseBody.get("duration");
            if(duration.equalsIgnoreCase("Job not done yet")){
                return responseBody;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return new JSONObject();
    }

    public JSONObject getData() throws IOException{
        CloseableHttpClient httpclient = HttpClients.createDefault();
        ResponseHandler<JSONObject> responseHandler =  new MyJSONResponseHandler();
        try {
            HttpGet httpget = new HttpGet(spark_host);
            JSONObject responseBody =  httpclient.execute(httpget, responseHandler);
            return responseBody;
        }
        catch (IOException e)
        {
            e.fillInStackTrace();
        }
        return new JSONObject();
    }
}
