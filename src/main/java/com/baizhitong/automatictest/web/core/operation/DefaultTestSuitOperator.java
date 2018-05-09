package com.baizhitong.automatictest.web.core.operation;

import com.baizhitong.automatictest.web.bean.context.TestContext;
import com.baizhitong.automatictest.web.bean.page.PageTask;

import java.util.Map;

/**
 * Created by wangsj on 2018/5/8.
 */
public class DefaultTestSuitOperator implements ITestSuitOperator{

    public void operate(TestContext context) {
        Map<String,PageTask> pageTasks = context.getPageTasks();
        pageTasks.forEach((k,v)->{

        });
    }
}
