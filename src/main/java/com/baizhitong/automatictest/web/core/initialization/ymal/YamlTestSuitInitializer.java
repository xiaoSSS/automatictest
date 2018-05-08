package com.baizhitong.automatictest.web.core.initialization.ymal;

import com.baizhitong.automatictest.web.bean.context.TestContext;
import com.baizhitong.automatictest.web.bean.page.PageObject;
import com.baizhitong.automatictest.web.bean.page.PageTask;
import com.baizhitong.automatictest.web.core.initialization.ITestSuitInitializer;
import org.ho.yaml.Yaml;

import java.net.URL;

import java.io.File;
import java.util.function.Function;


/**
 * Created by wangsj on 2018/5/8.
 */
public class YamlTestSuitInitializer implements ITestSuitInitializer {

    private static final String PAGE_ROOT = "/page";

    private static final String TASK_ROOT = "/task";

    public void init(TestContext context) {

        initPageObject(context);
    }

    private void initPageObject(TestContext context){
        URL pageUrl = YamlTestSuitInitializer.class.getClassLoader().getResource(PAGE_ROOT);
        if(pageUrl == null) {
            pageUrl = YamlTestSuitInitializer.class.getResource(PAGE_ROOT);
        }
        File file = new File(pageUrl.getFile());
        findYaml(file,(f)->{
            try {
                PageObject pageObject = Yaml.loadType(f, PageObject.class);
                context.addPageObject(pageObject);
            }catch (Exception ex){}
            return null;
        });

    }

    private void initPageTask(TestContext context){
        URL pageUrl = YamlTestSuitInitializer.class.getClassLoader().getResource(TASK_ROOT);
        if(pageUrl == null) {
            pageUrl = YamlTestSuitInitializer.class.getResource(TASK_ROOT);
        }
        File file = new File(pageUrl.getFile());
        findYaml(file,(f)->{
            try{
                PageTask pageTask = Yaml.loadType(f,PageTask.class);

            }catch (Exception ex){}
            return null;
        });
    }

    private void findYaml(File file, Function<File,?> function){
        if(file.isDirectory()){
            File[] subFiles = file.listFiles();
            for(File f:subFiles){
                findYaml(f,function);
            }
        }else{
            try {
                function.apply(file);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
