package com.action.dataset;

import com.entity.DatasetEntity;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@Component("dataAction")
@Scope("prototype")
public class DatasetAction extends ActionSupport {
    private File file;
    private String name;
    //private String exampleInputFileFileName;

    public void setFile(File file) {
        System.out.println(file);
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    //public void setExampleInputFileFileName(String exampleInputFileFileName) {
    //this.exampleInputFileFileName = exampleInputFileFileName;
    //}

    public String putData() throws IOException{
        System.out.println("文件action*******************");
        System.out.println(name);
        //System.out.println(exampleInputFile);
        if (file!=null){
            //File severFile=new File("E://dataset"+"/test.txt");//+exampleInputFileFileName);
            //FileUtils.copyFile(exampleInputFile,severFile);
        }
        return "success";
    }
    public void setName(String name) {
        this.name = name;
    }
}
