package com.baizhitong.automatictest.web.core.operation;

import com.baizhitong.automatictest.web.bean.context.TestContext;
import com.baizhitong.automatictest.web.bean.page.PageTask;

import java.util.List;
import java.util.Map;

/**
 * Created by wangsj on 2018/5/8.
 */
public class DefaultTaskOperator implements ITaskOperator {

    public void operate(PageTask task,Map elementData) {
        List<PageTask.TaskStep> steps = task.getSteps();
        steps.forEach(step -> {
            step.getPageObject();
        });
    }
}
