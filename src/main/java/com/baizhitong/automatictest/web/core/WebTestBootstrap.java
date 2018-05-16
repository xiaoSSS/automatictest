package com.baizhitong.automatictest.web.core;

import com.baizhitong.automatictest.web.bean.context.TestContext;
import com.baizhitong.automatictest.web.bean.data.TestData;
import com.baizhitong.automatictest.web.bean.page.PageTask;
import com.baizhitong.automatictest.web.core.dataprovider.IDataProvider;
import com.baizhitong.automatictest.web.core.dataprovider.yaml.YamlDataProvider;
import com.baizhitong.automatictest.web.core.initialization.ITestSuitInitializer;
import com.baizhitong.automatictest.web.core.initialization.yaml.YamlTestSuitInitializer;
import com.baizhitong.automatictest.web.core.operation.DefaultTaskOperator;
import com.baizhitong.automatictest.web.core.operation.ITaskOperator;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wangsj on 2018/5/8.
 */
public class WebTestBootstrap {

    ITestSuitInitializer initializer;

    IDataProvider dataProvider;

    ITaskOperator operator;

    TestContext context ;

    @BeforeClass
    public void pre(){
        context = new TestContext();
        Reporter.clear();
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver/chromedriver.exe");

        initializer = new YamlTestSuitInitializer();
        dataProvider = new YamlDataProvider();
        operator = new DefaultTaskOperator();

        initializer.init(context);      //初始化测试套件
        dataProvider.provideTestData(context);     //提供测试数据

    }

    @Test(dataProvider = "loadData")
    public void main(PageTask task,Map elementData){


    }

    @DataProvider
    public Object[][] loadData(){
        List<Object[]> returnData = new ArrayList<>();
        Map<String,PageTask> tasks = context.getPageTasks();
        Map<String,TestData> testData = context.getTestDatas();
        testData.forEach((k,v) -> {
            if(v!=null) {
                String taskId = v.getTaskId();
                PageTask task = tasks.get(taskId);
                if (task != null) {
                    v.getElementData().forEach(data->{
                        Object[] objects = new Object[]{task,data};
                        returnData.add(objects);
                    });
                }
            }
        });
        return returnData.toArray(new Object[returnData.size()][]);
    }


}
