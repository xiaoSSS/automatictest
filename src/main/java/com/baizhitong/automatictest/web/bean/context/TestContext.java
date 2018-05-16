package com.baizhitong.automatictest.web.bean.context;

import com.baizhitong.automatictest.web.bean.data.TestData;
import com.baizhitong.automatictest.web.bean.page.PageObject;
import com.baizhitong.automatictest.web.bean.page.PageTask;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by wangsj on 2018/5/8.
 */
public class TestContext {

    public TestContext(){
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver/chromedriver.exe");
    }

    private Map<String,PageObject> pageObjects = new LinkedHashMap<>();

    private Map<String,PageTask> pageTasks = new LinkedHashMap<>();

    private Map<String,TestData> testDatas = new LinkedHashMap<>();

    public void addPageObject(PageObject pageObject){
        if(null == pageObject) {
            return;
        }
        pageObjects.put(pageObject.getId(),pageObject);
    }

    public PageObject getPageObject(String id){
        return pageObjects.get(id);
    }

    public void addPageTask(PageTask pageTask){
        if(null == pageTask) {
            return;
        }
        pageTasks.put(pageTask.getId(),pageTask);
    }

    public Map<String,PageTask> getPageTasks(){
        return pageTasks;
    }

    public void addTestData(TestData testData){
        if(null == testData){
            return;
        }
        testDatas.put(testData.getId(),testData);
    }

    public Map<String,TestData> getTestDatas() {
        return testDatas;
    }
}

