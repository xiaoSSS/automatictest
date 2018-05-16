package com.baizhitong.automatictest.web.core.initialization.yaml;

import com.baizhitong.automatictest.web.bean.context.TestContext;
import com.baizhitong.automatictest.web.bean.page.PageObject;
import com.baizhitong.automatictest.web.bean.page.PageTask;
import com.baizhitong.automatictest.web.core.initialization.ITestSuitInitializer;
import com.baizhitong.automatictest.web.utils.YamlFileUtils;
import org.ho.yaml.Yaml;

import java.net.URL;

import java.io.File;


/**
 * Created by wangsj on 2018/5/8.
 */
public class YamlTestSuitInitializer implements ITestSuitInitializer {

    private static final String PAGE_ROOT = "/page";

    private static final String TASK_ROOT = "/task";

    public void init(TestContext context) {
        initPageObject(context);
        initPageTask(context);
    }

    private void initPageObject(TestContext context){
        YamlFileUtils.findYaml(PAGE_ROOT,(f)->{
            try {
                PageObject pageObject = Yaml.loadType(f, PageObject.class);
                context.addPageObject(pageObject);
            }catch (Exception ex){}
            return null;
        });

    }

    private void initPageTask(TestContext context){
        YamlFileUtils.findYaml(TASK_ROOT,(f)->{
            try{
                PageTask pageTask = Yaml.loadType(f,PageTask.class);
                pageTask.initTaskStep(context);
                context.addPageTask(pageTask);
            }catch (Exception ex){}
            return null;
        });
    }


}
